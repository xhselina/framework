package org.china.framework.spring.pattern.builder.impl;

import org.china.framework.spring.pattern.builder.CarBuilder;
import org.china.framework.spring.pattern.builder.model.CarModel;
import org.china.framework.spring.pattern.builder.model.impl.BMWModel;

import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 11:45.
 */
public class BMWCarBuilder implements CarBuilder {
    private CarModel bmwModel = new BMWModel();
    /**
     * 设置组装顺序
     *
     * @param sequence
     */
    @Override
    public void setSequence(List<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    /**
     * 获得车辆
     */
    @Override
    public CarModel getCarModel() {
         return this.bmwModel;
    }
}
