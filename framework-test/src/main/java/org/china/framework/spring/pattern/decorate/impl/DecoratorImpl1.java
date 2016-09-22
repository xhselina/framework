package org.china.framework.spring.pattern.decorate.impl;

import org.china.framework.spring.pattern.decorate.Decorator;
import org.china.framework.spring.pattern.decorate.SchoolReport;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 10:40.
 */
public class DecoratorImpl1 extends Decorator {
    public DecoratorImpl1(SchoolReport _schoolReport) {
        super(_schoolReport);
    }

    private void showMaxScore(){
        System.out.println("语文最好的成绩是 75 数学最好的成绩是 60  英语最好的成绩是 79  理综最好的成绩是 200");
    }

    @Override
    public void report() {
        this.showMaxScore();
        super.report();
    }
}
