package org.china.framework.spring.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/25 15:15.
 */
public class Client extends Thread{

    Semaphore position;
    private  int id;

    public Client(int i,Semaphore s) {
        this.position = s;
        this.id = i;
    }

    @Override
    public void run() {
        System.out.println("还剩余" + position.availablePermits() + "坑位没有被使用!");
        if (position.availablePermits() > 0){
            System.out.println("顾客【" + this.id + "】进入厕所，还有空位");
        }else {
            System.out.println("顾客【" + this.id + "】进入厕所，没有空位，需要排队。。。");
        }

        try {
            position.acquire();
            System.out.println("顾客【" + this.id + "】获得坑位");
            TimeUnit.SECONDS.sleep(1);
            position.release();
            System.out.println("顾客["+this.id+"]使用完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        // 模拟10个人
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        // 模拟坑位
//        Semaphore semaphore = new Semaphore(2);
//
//        for (int i=1; i<=10; i++){
//            executorService.submit(new Client(i,semaphore));
//        }
//
//        executorService.shutdown();
//
//        semaphore.acquireUninterruptibly(2);
//        System.out.println("使用完毕，需要清扫了");
//        semaphore.release(2);

        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 10; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 6000));
                        // 访问完后，释放
                        semp.release();
                        //availablePermits()指的是当前信号灯库中有多少个可以被使用
                        System.out.println("-----------------" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();

    }
}
