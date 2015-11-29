package org.china.framework.spring.model;

/**
 * Created by jeffrey on 15-11-22.
 */
public class CarFactory {
    public Car createrHongQi(){
        Car car = new Car("红色1","红旗",2000);
        return  car;
    }

    public static Car createrStaticHOngQi(){
        Car car = new Car("红色2","红旗静态",20000);
        return  car;
    }
}
