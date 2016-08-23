package org.china.framework.spring.pattern.command.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jeffrey on 15-11-28.
 */
public class ReceiverImpl1  extends  Receiver{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverImpl1.class);
    @Override
    public void doSomething() {
        LOGGER.info("接收者1做一些事情...");
    }
}
