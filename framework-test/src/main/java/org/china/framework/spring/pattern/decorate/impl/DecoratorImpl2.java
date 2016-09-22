package org.china.framework.spring.pattern.decorate.impl;

import org.china.framework.spring.pattern.decorate.Decorator;
import org.china.framework.spring.pattern.decorate.SchoolReport;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 10:40.
 */
public class DecoratorImpl2 extends Decorator {
    public DecoratorImpl2(SchoolReport _schoolReport) {
        super(_schoolReport);
    }

    private void showDesc(){
        System.out.println("您孩子在班级的排名是：25名");
    }

    @Override
    public void report() {
        this.showDesc();
        super.report();
    }
}
