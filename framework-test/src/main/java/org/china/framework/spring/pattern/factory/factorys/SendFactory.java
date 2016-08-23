package org.china.framework.spring.pattern.factory.factorys;

import org.china.framework.spring.pattern.factory.Sender;
import org.china.framework.spring.pattern.factory.factorys.impl.MailSenderImpl;
import org.china.framework.spring.pattern.factory.factorys.impl.SmsSenderImpl;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:32.
 */
public class SendFactory {
    public Sender sendSms(){
        return new SmsSenderImpl();
    }

    public Sender SendMail(){
        return new MailSenderImpl();
    }
}
