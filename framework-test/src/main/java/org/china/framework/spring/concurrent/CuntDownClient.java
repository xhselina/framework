package org.china.framework.spring.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/24 16:41.
 */
public class CuntDownClient {
    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i=0; i<count; i++){
            final int index = i;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + index + "has finish");
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println("所有运动员都跑步结束");
    }
}
