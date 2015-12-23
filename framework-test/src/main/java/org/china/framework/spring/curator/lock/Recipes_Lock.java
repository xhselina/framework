package org.china.framework.spring.curator.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.china.framework.spring.curator.common.CuratorCommon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jeffrey
 * @version v1.0
 * @date 15-12-22 下午11:56
 */
public class Recipes_Lock {
    public static void main(String[] args) throws Exception{
        final String path = "/drake/lock";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);

        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(CuratorCommon.CONNECTION_STRING)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(6000)
                .retryPolicy(retryPolicy)
                .build();
        client.start();

        final InterProcessMutex lock = new InterProcessMutex(client,path);
        final CountDownLatch downLatch = new CountDownLatch(1);
        for(int i=0; i<40 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        downLatch.await();
                        lock.acquire();
                    }  catch (Exception e) {
                        e.printStackTrace();
                    }

                    SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm:ss|SSS");
                    String str = simpleFormatter.format(new Date());
                    System.err.println("生成的订单号:" + str);

                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            downLatch.countDown();
        }
    }
}
