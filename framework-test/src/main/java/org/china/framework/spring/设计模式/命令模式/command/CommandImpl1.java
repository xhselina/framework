package org.china.framework.spring.设计模式.命令模式.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.china.framework.spring.设计模式.命令模式.receiver.Receiver;
import org.china.framework.spring.设计模式.命令模式.receiver.ReceiverImpl1;

/**
 * Created by jeffrey on 15-11-28.
 */
public class CommandImpl1 extends  Command {
    static final Logger LOGGER = LogManager.getLogger();

    //默认的接收人
    public CommandImpl1(){
        super(new ReceiverImpl1());
    }
    //新的接收人
    public CommandImpl1(Receiver _receiver){
        super(_receiver);
    }
    @Override
    public void execute() {
       super.receiver.doSomething();
        LOGGER.info("命令1被执行...");

    }
}
