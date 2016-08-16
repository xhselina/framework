package org.china.framework.spring.设计模式.template;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/10 9:02.
 */
public class ConcreteClass1 extends AbstractTemplateClass {
    @Override
    protected void method1() {
        System.out.println(this.getClass().getName() + "method1");
    }

    @Override
    protected void method2() {
        System.out.println(this.getClass().getName() + "method2");
    }
}
