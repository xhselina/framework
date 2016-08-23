package org.china.framework.spring.pattern.factory.staticfactory;

import org.china.framework.spring.pattern.factory.Sender;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:34.
 */
public class Client {
    public static void main(String[] args) {
        Sender sender = SendFactory.sendSms();
        System.out.println(sender.send());
    }
}
