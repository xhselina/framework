package org.china.framework.spring.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by jeffrey on 15-11-11.
 */
@Configurable
public class Beans {

    @Bean(name = "car2")
    public Car buildCar(){
        Car car = new Car();
        car.setColor("红色");
        car.setPrice(10000);
        return  car;
    }
}
