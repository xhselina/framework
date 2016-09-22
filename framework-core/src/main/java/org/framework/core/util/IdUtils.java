package org.framework.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/21 11:47.
 */
public class IdUtils {
    private static AtomicLong sequence = new AtomicLong();

    private final static long epoch = 1356969600000L;
    private static  long compId = 0L;
    private static AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        System.out.println("初始化的lastTime:" + lastTime.get());
        int threadNum = 10;
        ConcurrentHashMap map = new ConcurrentHashMap();

        for (int j=0; j<1; j++){
            CountDownLatch countDownLatch = new CountDownLatch(threadNum);
            for(int i=0; i<threadNum; i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<10; i++){
                            long aa = System.currentTimeMillis();
                            System.out.println(aa);
                        long start = aa - epoch;
//                            long aa = lastTime.incrementAndGet();
//                            System.out.println("aa的值:" + aa);
//                            long start = aa -epoch;

                            long result = start << 23;
                            result = result | (compId << 10);
                            sequence.addAndGet(1);
                            long seq = sequence.longValue() % 1024;
                            result = result | seq;
//                            System.out.println(result);
                            if (map.containsKey(result)){
                                System.out.println(result + "已经生成过了");
                            }else{
                                map.put(result,result);
                            }
//                        System.out.println("map的长度:" + map.keySet().size());
                        }
                        countDownLatch.countDown();
                    }
                }).start();
            }
            countDownLatch.await();
        }
        System.out.println("map的长度:" + map.keySet().size());
    }
}
