package org.china.framework.spring.设计模式.template;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/10 8:58.
 */
public abstract class AbstractTemplateClass {
    protected abstract void method1();
    protected abstract void method2();

    public void executeTemplate(){
        this.method1();
        this.method2();
    }


}
