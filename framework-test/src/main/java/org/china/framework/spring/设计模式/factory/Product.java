package org.china.framework.spring.设计模式.factory;

/**
 * 工厂可生产的 产品类
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/9 13:14.
 */
public abstract class Product {
    public void method1(){
        System.out.println("所有子类共用的方法");
    }

    // 需要子类覆盖，子类个性化的部分
    protected  void method2(){};
}
