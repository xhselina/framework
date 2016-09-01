package org.china.framework.spring.pattern.observerp.impl;

import java.util.Observable;
import java.util.Observer;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/31 10:19.
 */
public class LiSi implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.countObservers());
        System.out.println("李斯开始向秦老板汇报:");
        System.out.println(arg.toString());
    }
}
