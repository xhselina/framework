package org.china.framework.spring.设计模式.template;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/10 9:03.
 */
public class Client {
    public static void main(String[] args) {
        new ConcreteClass1().executeTemplate();
        new ConcreteClass2().executeTemplate();
    }
}
