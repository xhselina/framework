package org.china.framework.spring.mq.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/1 17:28.
 */
public class Receive {
    public static void main(String[] args) throws  Exception{
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://192.168.6.130:61616");

        connection = connectionFactory.createConnection();

        connection.start();
        session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);

        destination = session.createQueue("test-queue");
        consumer = session.createConsumer(destination);
        System.out.println("消费端开始消费消息:");
        int temp = 0;
        while (true){
            TextMessage textMessage = (TextMessage) consumer.receive(1000000);
            if (null != textMessage){
                System.out.println("收到消息" + textMessage.getText() + "第" + temp ++ + "个！");

            } else {
                break;
            }
        }

        connection.close();
    }
}
