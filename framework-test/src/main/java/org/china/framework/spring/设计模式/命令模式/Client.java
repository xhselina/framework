package org.china.framework.spring.设计模式.命令模式;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.china.framework.spring.设计模式.命令模式.command.Command;
import org.china.framework.spring.设计模式.命令模式.command.CommandImpl1;


/**
 * Created by jeffrey on 15-11-28.
 */
public class Client {
    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    public static void main(String[] args) {
        LOGGER.info("哈哈");
        //定义接受人
       // Receiver receiver = new ReceiverImpl1();
        //创建一个命令
        Command command = new CommandImpl1();
        //由执行人 执行任务
        Invoker invoker = new Invoker(command);

        invoker.action();
    }
}
