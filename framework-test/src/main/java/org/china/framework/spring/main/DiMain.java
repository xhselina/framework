package org.china.framework.spring.main;

import org.china.framework.spring.model.Car;
import org.china.framework.spring.model.Foo;
import org.china.framework.spring.model.MethodDI;
import org.china.framework.spring.model.TypeModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jeffrey on 15-11-22.
 */
public class DiMain {
    public static void main(String[] args) {
        ApplicationContext act = new  ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //属性注入
        Foo foo = (Foo)act.getBean("foo");
        System.out.println(foo.getiDCode());
        //构造方法注入
//        Car car = (Car) act.getBean("car2");
//        car.print();
//
//        Car car3 = (Car) act.getBean("car3");
//        car3.print();

        Car car4 = (Car) act.getBean("car4");
        car4.print();

        Car car5 = (Car) act.getBean("car5");
        car5.print();

        ApplicationContext sonAct = new  ClassPathXmlApplicationContext(new String[]{"son.xml"},act);

        TypeModel typeModel = (TypeModel) sonAct.getBean("typeModel");
        System.out.println(typeModel.getCar().getColor());
        System.out.println(typeModel.getList().get(0));
        System.out.println(typeModel.getSet().toArray());

        MethodDI methodDI = (MethodDI) sonAct.getBean("methodDi");
        System.out.println(methodDI.getCar());
        System.out.println(methodDI.getCar());
        System.out.println(methodDI.getCar());


    }
}
