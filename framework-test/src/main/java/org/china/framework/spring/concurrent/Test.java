package org.china.framework.spring.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/6/21 17:36.
 */
public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List list = new ArrayList<>();
        int total = 10000000;

        for (int i=0; i<total; i++){
          list.add(i);
        }
        System.out.println("总共耗时:" + (System.currentTimeMillis() - start));
        System.out.println(list.size());
    }

}

