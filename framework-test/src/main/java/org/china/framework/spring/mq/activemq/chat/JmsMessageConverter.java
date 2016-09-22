package org.china.framework.spring.mq.activemq.chat;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/2 16:15.
 */
public class JmsMessageConverter implements MessageConverter {
    /**
     * Convert a Java object to a JMS Message using the supplied session
     * to create the message object.
     *
     * @param object  the object to convert
     * @param session the Session to use for creating a JMS Message
     * @return the JMS Message
     * @throws JMSException               if thrown by JMS API methods
     * @throws MessageConversionException in case of conversion failure
     */
    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        return null;
    }

    /**
     * Convert from a JMS Message to a Java object.
     *
     * @param message the message to convert
     * @return the converted Java object
     * @throws JMSException               if thrown by JMS API methods
     * @throws MessageConversionException in case of conversion failure
     */
    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        return null;
    }
}
