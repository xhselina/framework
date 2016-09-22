package org.china.framework.spring.pattern.decorate;

import org.china.framework.spring.pattern.decorate.impl.DecoratorImpl1;
import org.china.framework.spring.pattern.decorate.impl.DecoratorImpl2;
import org.china.framework.spring.pattern.decorate.impl.MyScoreReportImpl;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 10:30.
 */
public class Client {
    public static void main(String[] args) {
        SchoolReport schoolReport = new MyScoreReportImpl();
//        schoolReport.report();

        schoolReport = new DecoratorImpl2(schoolReport);
        schoolReport = new DecoratorImpl1(schoolReport);
        schoolReport.report();
        schoolReport.sign("老三");
    }
}
