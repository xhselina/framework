package org.china.framework.spring.concurrent.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/25 13:59.
 */
public class ExecutorTest extends Thread{

    private  int index;

    public ExecutorTest(int x){
        this.index = x;
    }

    @Override
    public void run() {
        try {
            System.out.println("["+this.index+"] start....");
            Thread.sleep((int)(Math.random()*1000));
            System.out.println("["+this.index+"] end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws  Exception {

        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("jeffrey-%5d")
                .setDaemon(true)
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(4,threadFactory);

        for (int i=0 ; i<10; i++){
//            executorService.execute(new ExecutorTest(i));

            Future future = executorService.submit(new ExecutorTest(i));
            System.out.println(future.get());
        }

        System.out.println("submit finish");

        Future future = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return "abcdef";
            }
        });
        System.out.println(future.get());
        executorService.shutdown();
    }
}
