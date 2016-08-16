package org.china.framework.spring.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/24 16:00.
 */
public class BlockQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<String>(10);
        int size = blockingQueue.size() ;
        System.out.println("blockingQueue size is " + size);
        for (int i=0; i<10; i++){
//            blockingQueue.add(i + "");   满了后 抛出异常
//            boolean flag = blockingQueue.offer(i + "");  添加失败后返回false,但是不抛出异常
            try {
                blockingQueue.put(i + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(flag ? "添加成功":"添加失败");
        }
        size = blockingQueue.size() ;
        System.out.println("blockingQueue size is " + size);
    }
}
