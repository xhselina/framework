package org.china.framework.spring.pattern.builder.impl;

import org.china.framework.spring.pattern.builder.CarBuilder;
import org.china.framework.spring.pattern.builder.model.CarModel;
import org.china.framework.spring.pattern.builder.model.impl.BenModel;

import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 13:02.
 */
public class BenCarBuilder implements CarBuilder {
    private BenModel benModel = new BenModel();
    /**
     * 设置组装顺序
     *
     * @param sequence
     */
    @Override
    public void setSequence(List<String> sequence) {
        this.benModel.setSequence(sequence);
    }

    /**
     * 获得车辆
     */
    @Override
    public CarModel getCarModel() {
        return this.benModel;
    }
}
