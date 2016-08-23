package org.china.framework.spring.pattern.command;

import org.china.framework.spring.pattern.command.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据命令执行任务
 * Created by jeffrey on 15-11-28.
 */
public class Invoker {
    //需要执行的命令
//    private Command command;

    private List<Command> commands = new ArrayList<>();

    public Invoker(){}
    //接受命令
    public Invoker(Command command){
        commands.add(command);
//        this.command = command;
    }

    public Invoker(List<Command> commands){
       this.commands.addAll(commands);
    }
    //执行任务
    public void action(){
        if (null != commands && commands.size() > 0){
            for (Command command:commands){
                command.execute();
            }
        }
    }
}
