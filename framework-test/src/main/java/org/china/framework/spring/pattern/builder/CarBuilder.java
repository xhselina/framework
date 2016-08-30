package org.china.framework.spring.pattern.builder;

import org.china.framework.spring.pattern.builder.model.CarModel;

import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 11:31.
 */
public interface CarBuilder {
    /**
     * 设置组装顺序
     */
    public void setSequence(List<String> sequence);

    /**
     * 获得车辆
     */
    public CarModel getCarModel();
}
