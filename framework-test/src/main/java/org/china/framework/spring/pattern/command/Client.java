package org.china.framework.spring.pattern.command;

import org.china.framework.spring.pattern.command.receiver.Receiver;
import org.china.framework.spring.pattern.command.receiver.ReceiverImpl1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.china.framework.spring.pattern.command.command.Command;
import org.china.framework.spring.pattern.command.command.CommandImpl1;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jeffrey on 15-11-28.
 */
public class Client {
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
        LOGGER.info("哈哈");
        List<Command> commandList = new ArrayList<>();
        //定义接受人
        Receiver receiver = new ReceiverImpl1();
        //创建一个命令
        Command command = new CommandImpl1(receiver);

        Command command1 = new CommandImpl1(receiver);

        commandList.add(command);
        commandList.add(command1);
        //由执行人 执行任务
        Invoker invoker = new Invoker(commandList);
        invoker.action();
    }
}
