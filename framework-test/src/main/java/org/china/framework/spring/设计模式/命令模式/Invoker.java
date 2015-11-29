package org.china.framework.spring.设计模式.命令模式;

import org.china.framework.spring.设计模式.命令模式.command.Command;

/**
 * 根据命令执行任务
 * Created by jeffrey on 15-11-28.
 */
public class Invoker {
    //需要执行的命令
    private Command command;

    public Invoker(){}
    //接受命令
    public Invoker(Command command){
        this.command = command;
    }
    //执行任务
    public void action(){
        this.command.execute();
    }
}
