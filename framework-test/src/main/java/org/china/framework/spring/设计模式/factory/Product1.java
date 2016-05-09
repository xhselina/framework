package org.china.framework.spring.设计模式.factory;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/9 13:17.
 */
public class Product1 extends  Product {
    @Override
    protected void method2() {
        System.out.println("Product1 这个子类自己特有的方法");
    }
}
