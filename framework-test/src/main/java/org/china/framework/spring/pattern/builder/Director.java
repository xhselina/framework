package org.china.framework.spring.pattern.builder;

import org.china.framework.spring.pattern.builder.impl.BMWCarBuilder;
import org.china.framework.spring.pattern.builder.impl.BenCarBuilder;
import org.china.framework.spring.pattern.builder.model.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 13:05.
 */
public class Director {

    private List<String> sequence = new ArrayList<>();
    private CarBuilder bmwBuilder = new BMWCarBuilder();
    private CarBuilder benBuilder = new BenCarBuilder();

    public CarModel buildBMWH1(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return this.bmwBuilder.getCarModel();
    }

    public CarModel buildBMWH2(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return this.bmwBuilder.getCarModel();
    }

    public CarModel buildBenH1(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benBuilder.setSequence(this.sequence);
        return this.benBuilder.getCarModel();
    }

    public CarModel buildBenH2(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.sequence.add("stop");
        this.benBuilder.setSequence(this.sequence);
        return this.benBuilder.getCarModel();
    }
}
