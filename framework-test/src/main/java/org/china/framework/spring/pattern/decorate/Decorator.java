package org.china.framework.spring.pattern.decorate;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 10:32.
 */
public abstract class Decorator extends SchoolReport {
    private SchoolReport schoolReport;

    public Decorator(SchoolReport _schoolReport){
        this.schoolReport = _schoolReport;
    }

    public void report(){
        this.schoolReport.report();
    }

    public void sign(String name){
        this.schoolReport.sign(name);
    }

}
