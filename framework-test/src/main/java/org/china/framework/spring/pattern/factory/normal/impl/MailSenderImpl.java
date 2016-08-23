package org.china.framework.spring.pattern.factory.normal.impl;

import org.china.framework.spring.pattern.factory.Sender;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:17.
 */
public class MailSenderImpl implements Sender{
    @Override
    public String send() {
        return "邮件发送start...";
    }
}
