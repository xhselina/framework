package org.china.framework.spring.设计模式.责任链模式;

/**
 * Created by junhuiji on 2015/12/10.
 */
public class Father extends Handler {

    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
       System.out.println("女儿向父亲请示：");
        women.getRequest();
        System.out.println("父亲答复：同意");
    }
}
