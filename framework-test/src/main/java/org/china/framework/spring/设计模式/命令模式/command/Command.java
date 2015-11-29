package org.china.framework.spring.设计模式.命令模式.command;

import org.china.framework.spring.设计模式.命令模式.receiver.Receiver;

/**
 *  需要执行的领命，由于有多个命令，所以是抽象类
 * Created by jeffrey on 15-11-28.
 */
public abstract class Command {

    protected final Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }
//    执行命令
    public abstract  void execute();
}
