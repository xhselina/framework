package org.china.framework.spring.pattern.享元模式;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/4/11 8:50.
 */
public class ConcreteFlyweight extends  Flyweight {
    // 接收外部状态
    public ConcreteFlyweight(String _extrinsic) {
        super(_extrinsic);
    }

    @Override
    public void operation(String extStatus) {
        System.out.println("共享的Flyweight : " + extStatus);
    }
}
