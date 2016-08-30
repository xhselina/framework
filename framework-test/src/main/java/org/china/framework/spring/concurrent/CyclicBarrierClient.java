package org.china.framework.spring.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/26 11:23.
 *  今天晚上我们哥们4个去Happy。就互相通知了一下：晚上八点准时到xx酒吧门前集合，不见不散！。
 *  有个哥们住的近，早早就到了。
 *  有的事务繁忙，刚好踩点到了。无论怎样，先来的都不能独自行动，只能等待所有人
 */
public class CyclicBarrierClient {
    public static void main(String[] args) {
        int n = 4; // 表示总共4个人
       // 模拟4个人
        ExecutorService executorService = Executors.newCachedThreadPool();

        final  CyclicBarrier cyclicBarrier = new CyclicBarrier(n,new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(n + "个人都到期了，可以去happy了!");
            }
        });

        for (int i=0; i<n; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "已经出发在路上，再过3秒钟就到了!");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(Thread.currentThread().getName() + "到了！");
                        //等待其他人
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        System.out.println("cyclicBarrier 重用");

        for (int i=0; i<n; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "已经出发在路上，再过3秒钟就到了!");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(Thread.currentThread().getName() + "到了！");
                        //等待其他人
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
