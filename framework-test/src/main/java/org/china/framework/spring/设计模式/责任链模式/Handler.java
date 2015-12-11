package org.china.framework.spring.设计模式.责任链模式;

/**
 * Created by junhuiji on 2015/12/10.
 */
public abstract class Handler {

    public static final int FATHER_LEVEL_REQUEST = 1;
    public static final int HUSBAND_LEVEL_REQUEST = 2;
    public static final int SON_LEVEL_REQUEST = 3;

    //能处理的级别
    private int leavel = 0;
    // 责任链的下一个执行人
    private Handler nextHandler;

    public Handler(int _level){
        this.leavel =   _level;
    }
     // 有请示，就要有回应  具体回应 由子类完成
    protected  abstract void response(IWomen women);

    // 如果 该节点执行不了该请求，则设置下个处理请求的对象
    public void setNextHandler(Handler _nextHandler){
        this.nextHandler = _nextHandler;
    }

    // 请求处理的过程
    public  final  void handleMessage(IWomen iWomen) {
        if (iWomen.getType() == this.leavel){
            this.response(iWomen);
        }else{
            if (this.nextHandler != null){// 有后续环节，则继续执行
                 this.nextHandler.response(iWomen);
            }else{// 没有后续环节，则默认处理
                System.out.println("没有后续环境，over！");
            }
        }
    }
}
