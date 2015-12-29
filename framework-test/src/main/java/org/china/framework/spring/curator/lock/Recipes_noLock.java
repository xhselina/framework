package org.china.framework.spring.curator.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jeffrey
 * @version v1.0
 * @date 15-12-22 下午11:45
 */
public class Recipes_noLock {
    public static void main(String[] args) {
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
       for(int i=0; i<10; i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
//                       countDownLatch.await();
                       Thread.sleep(5000);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   SimpleDateFormat simpleFormatter = new SimpleDateFormat("HH:mm:ss|SSS");
                   String str = simpleFormatter.format(new Date());
                   System.err.println("生成的订单号:" + str);
               }
           }).start();

       }
//       countDownLatch.countDown();
    }
}
