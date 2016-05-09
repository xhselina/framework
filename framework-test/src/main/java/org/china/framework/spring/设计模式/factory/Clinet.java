package org.china.framework.spring.设计模式.factory;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/9 13:24.
 */
public class Clinet {
    public static void main(String[] args) {
        Product product1 = (Product1)ProductFactory.createProduct(Product1.class);
        Product product2 = (Product2)ProductFactory.createProduct(Product2.class);
        product1.method2();
        product2.method2();
    }

}
