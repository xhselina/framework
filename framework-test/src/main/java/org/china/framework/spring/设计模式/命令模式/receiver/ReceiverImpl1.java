package org.china.framework.spring.设计模式.命令模式.receiver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by jeffrey on 15-11-28.
 */
public class ReceiverImpl1  extends  Receiver{
    static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void doSomething() {
        LOGGER.info("接收者1做一些事情...");
    }
}
