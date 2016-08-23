package org.china.framework.spring.pattern.责任链模式;

/**
 * Created by junhuiji on 2015/12/10.
 */
public class Son extends Handler {

    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women) {
       System.out.println("母亲向儿子请示：");
        women.getRequest();
        System.out.println("儿子答复：同意");
    }
}
