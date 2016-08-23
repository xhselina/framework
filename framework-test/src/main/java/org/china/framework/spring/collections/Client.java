package org.china.framework.spring.collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/17 16:14.
 */
public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
         listTest();
    }

    public static void listTest(){
        List arrayList = new ArrayList<>();
        for (int i=0; i<20; i++){
            arrayList.add(i);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            logger.info(iterator.next().toString());
        }

        for (Object o:arrayList){
            logger.info(o.toString());
        }
        List vectorList = new Vector<>();


        List linkedList = new LinkedList<>();
        List syncLinkedList = Collections.synchronizedList(new LinkedList<>());

    }

    public static void setTest(){
        Set set = new  HashSet();

    }
}
