package org.china.framework.spring.pattern.decorate.impl;

import org.china.framework.spring.pattern.decorate.SchoolReport;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 10:12.
 */
public class MyScoreReportImpl extends SchoolReport {
    @Override
    protected void report() {
        System.out.println("尊敬的xxx家长：\n");
        System.out.println("您孩子的成绩如下： 语文 65  数学39  英语 60 理综 125\n");
        System.out.println("                                                    家长签字:       ");

    }

    @Override
    protected void sign(String name) {
        System.out.println("家长签字：" + name);
    }


}
