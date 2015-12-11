package org.china.framework.spring.设计模式.责任链模式;

/**
 * Created by junhuiji on 2015/12/10.
 */
public class Women implements IWomen {

    // 女人的角色  女儿  妻子 母亲
    private int type = 0;
    // 女人的请求信息
    private String request = "";


    public Women(int _type,String _request){
        this.type = _type;

        switch (this.type){
            case 1 : this.request = "女儿的请求是:" + _request ;
                     break;
            case 2 : this.request = "妻子的请求是:" + _request;
                     break;
            case 3 : this.request = "母亲的请求是:" + _request;
                     break;
            default:
                this.request = "什么都不是";

        }
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
