package org.china.framework.spring.mq.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/1 17:11.
 */
public class Sender {
    private static final int SEND_NUMBER = 50000;
    public static void main(String[] args) throws Exception {
        // ConnectionFactory 连接工厂
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁
        Destination destination;
        // MessageProducer：消息发送者
        MessageProducer producer;

        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://192.168.6.130:61616");

        connection = connectionFactory.createConnection();

        connection.start();

        session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);

        destination = session.createQueue("test-queue");

        producer = session.createProducer(destination);
        // 不持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        sendMsg(session,producer);

        session.commit();
        connection.close();

    }

    public  static void sendMsg(Session session,MessageProducer producer)throws Exception{

       for(int i=0; i<SEND_NUMBER; i++){
            TextMessage textMessage = session.createTextMessage("activemq 发送消息" + i);
           // 发送消息到目的地方
           System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
           producer.send(textMessage);
       }
    }

}
