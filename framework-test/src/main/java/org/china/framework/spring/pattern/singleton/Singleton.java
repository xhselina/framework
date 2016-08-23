package org.china.framework.spring.pattern.singleton;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:59.
 */
public class Singleton {
    // 防止实例化
    private Singleton(){}

    private static class SingletonFactory{
        private  static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return  SingletonFactory.singleton;
    }


}
