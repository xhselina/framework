package org.china.framework.spring.mq.activemq.chat;

import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 16:10.
 */
public class JmsMessageListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        ActiveMQMapMessage msg = null;
        if (message instanceof ActiveMQMapMessage){
            msg = (ActiveMQMapMessage) message;
            try {
                String username = msg.getString("username");
                String password = msg.getString("password");
                System.out.println("Message::: "+username+", "+password);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
