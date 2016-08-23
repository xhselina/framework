package org.china.framework.spring.pattern.factory.normal;

import org.china.framework.spring.pattern.factory.Sender;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:22.
 *
 * 说明：
 */
public class Client {
    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.sendMsg("1");
        System.out.println(sender.send());
    }
}
