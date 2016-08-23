package org.china.framework.spring.pattern.factory.staticfactory;

import org.china.framework.spring.pattern.factory.Sender;
import org.china.framework.spring.pattern.factory.staticfactory.impl.MailSenderImpl;
import org.china.framework.spring.pattern.factory.staticfactory.impl.SmsSenderImpl;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:32.
 */
public class SendFactory {
    public static Sender sendSms(){
        return new SmsSenderImpl();
    }

    public static Sender SendMail(){
        return new MailSenderImpl();
    }
}
