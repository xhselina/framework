package org.china.framework.spring.model;

/**
 * Created by jeffrey on 15-11-22.
 */
public class Foo {
    private String iDCode;

    public void setiDCode(String iDCode) {
        this.iDCode = iDCode;
        System.out.println("开始注入");
    }

    public String getiDCode() {
        return iDCode;
    }
}



