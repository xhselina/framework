package org.china.framework.spring.pattern.享元模式;

import java.util.Hashtable;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/4/11 8:53.
 */
public class FlywightFactory  {
    private static  Hashtable<String,Flyweight> pool = new Hashtable<>();

    public Flyweight getFlyweight(String extrinsic){
        Flyweight result = null;
        if (pool.containsKey(extrinsic)){
            result = pool.get(extrinsic);
            System.out.println("在共享对象池中获取对象");
        } else{
            result = new ConcreteFlyweight(extrinsic);
            pool.put(extrinsic,result);
            System.out.println("new的对象，然后放入对象池中");
        }
          return result;
    }
}
