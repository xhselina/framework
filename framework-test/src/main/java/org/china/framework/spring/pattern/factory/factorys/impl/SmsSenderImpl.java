package org.china.framework.spring.pattern.factory.factorys.impl;

import org.china.framework.spring.pattern.factory.Sender;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:30.
 */
public class SmsSenderImpl implements Sender{
    @Override
    public String send() {
        return "发送短信";
    }
}
