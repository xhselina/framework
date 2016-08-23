package org.china.framework.spring.pattern.command.command;

import org.china.framework.spring.pattern.command.receiver.Receiver;
import org.china.framework.spring.pattern.command.receiver.ReceiverImpl1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jeffrey on 15-11-28.
 */
public class CommandImpl1 extends  Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandImpl1.class);


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
