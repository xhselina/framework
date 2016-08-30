package org.china.framework.spring.pattern.builder.model;

import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 11:09.
 */
public abstract class CarModel {
     private List<String> sequence ;

    /**
     * 启动
     */
    protected abstract void  start();

    /**
     * 停车
     */
    protected  abstract  void stop();

    /**
     * 按喇叭
     */
    protected abstract  void alarm();

    /**
     * 设置组装顺序
     * @param sequence
     */
    final public void setSequence(final List<String> sequence){
        this.sequence = sequence;
    }

    final public void  run(){
        for(String type:this.sequence){
            if (type.equals("start")){
                this.start();
            } else if (type.equals("stop")){
                this.stop();
            } else if(type.equals("alarm")){
                this.alarm();
            }
        }
        System.out.println("====================我是华丽分割线=========================");
    }


}
