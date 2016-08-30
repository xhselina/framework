package org.china.framework.spring.pattern.builder.model.impl;

import org.china.framework.spring.pattern.builder.model.CarModel;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 11:29.
 */
public class BenModel extends CarModel {
    /**
     * 启动
     */
    @Override
    protected void start() {
        System.out.println("奔驰车启动");
    }

    /**
     * 停车
     */
    @Override
    protected void stop() {
        System.out.println("奔驰车停车");
    }

    /**
     * 按喇叭
     */
    @Override
    protected void alarm() {
        System.out.println("奔驰车按喇叭");
    }
}
