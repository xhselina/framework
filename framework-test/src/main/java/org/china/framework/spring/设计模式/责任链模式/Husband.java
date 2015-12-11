package org.china.framework.spring.设计模式.责任链模式;

/**
 * Created by junhuiji on 2015/12/10.
 */
public class Husband extends Handler {

    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
       System.out.println("妻子向丈夫请示：");
        women.getRequest();
        System.out.println("丈夫答复：同意");
    }
}
