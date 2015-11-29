package org.china.framework.spring.main;

import org.china.framework.spring.model.Beans;
import org.china.framework.spring.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jeffrey on 15-11-11.
 */
public class AnnotationApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext ac = new  AnnotationConfigApplicationContext(Beans.class);
        Car car1 = (Car)ac.getBean("car2");
        car1.print();
    }
}
