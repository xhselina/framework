package org.china.framework.spring.pattern.享元模式;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/4/11 8:52.
 */
public class UnConcreateFlyweight extends Flyweight {
    // 接收外部状态 这里是不正常的外部状态
    public UnConcreateFlyweight(String _extrinsic) {
        super(_extrinsic);
    }

    @Override
    public void operation(String extStatus) {
        System.out.println("不需要共享的Flyweight :" + extStatus);
    }
}
