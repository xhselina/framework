package org.china.framework.spring.pattern.享元模式;

/**
 * 所有具体享元类的超类或接口，通过这个接口，Flyweight 可以接受并作用于外部状态
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/4/11 8:48.
 */
public abstract class Flyweight {
    // 内部状态
    private String intrinsic;

    //外部状态  这个状态不可改变   这里不一定是String 可以是任何对象  建议用基本类型 可以提高效率
    protected final String extrinsic;

    //享元模式 必须传入一个外部状态
    public Flyweight(String _extrinsic){
        this.extrinsic = _extrinsic;
    }
    // 具体操作业务
    public abstract void operation(String extStatus);

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
