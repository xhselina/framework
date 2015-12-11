package org.china.framework.spring.设计模式.责任链模式;

import java.util.Random;

/**
 * Created by junhuiji on 2015/12/10.
 */
public class Client {
    public static void main(String[] args) {

        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNextHandler(husband);
        husband.setNextHandler(son);

        for(int i = 0; i<10; i++){
            father.handleMessage(new Women(new Random().nextInt(4),"我要出去逛街..."));
        }
    }
}
