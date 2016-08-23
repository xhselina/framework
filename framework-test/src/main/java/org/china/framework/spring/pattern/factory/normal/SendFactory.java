package org.china.framework.spring.pattern.factory.normal;

import org.china.framework.spring.pattern.factory.Sender;
import org.china.framework.spring.pattern.factory.normal.impl.MailSenderImpl;
import org.china.framework.spring.pattern.factory.normal.impl.SmsSenderImpl;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 17:18.
 */
public class SendFactory {

    public Sender sendMsg(String type){

        if (type.equals("1")){  //发短信
             return new SmsSenderImpl();
         }else  if(type.equals("2")){  //发邮件
            return new MailSenderImpl();
        } else{
            System.out.println("类型输入有误..");
            return null;
        }
    }




}
