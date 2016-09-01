package org.china.framework.spring.pattern.observerp.impl;

import org.china.framework.spring.pattern.observerp.IHanFeiZi;

import java.util.Observable;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/31 10:16.
 */
public class HanFeiZiImpl extends Observable implements IHanFeiZi {
    @Override
    public void eat() {
        System.out.println("韩非子：开始吃饭了...");
        super.setChanged();
        super.notifyObservers("韩非子正在吃饭....");
    }

    @Override
    public void fun() {
        System.out.println("韩非子：开始娱乐...");
        super.setChanged();
        super.notifyObservers("韩非子正在娱乐...");
    }

    @Override
    public void report() {
        System.out.println("韩非子：开始报告...");
        super.setChanged();
        super.notifyObservers("韩非子正在报告...");
    }
}
