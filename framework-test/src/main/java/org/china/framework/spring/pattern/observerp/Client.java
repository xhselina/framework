package org.china.framework.spring.pattern.observerp;

import org.china.framework.spring.pattern.observerp.impl.HanFeiZiImpl;
import org.china.framework.spring.pattern.observerp.impl.LiSi;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/31 10:22.
 */
public class Client {
    public static void main(String[] args) {
        LiSi lisi = new LiSi();
        HanFeiZiImpl hanFeiZi = new HanFeiZiImpl();
        hanFeiZi.addObserver(lisi);
        hanFeiZi.eat();
        hanFeiZi.fun();
        hanFeiZi.report();
    }
}
