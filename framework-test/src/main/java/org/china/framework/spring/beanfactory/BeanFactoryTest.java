package org.china.framework.spring.beanfactory;

import org.china.framework.spring.model.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by jeffrey on 15-11-11.
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver rp = new PathMatchingResourcePatternResolver();
        Resource[] resources = rp.getResources("classpath:applicationContext.xml");
        for (Resource r: resources){
            System.out.println(r.getFilename());
            BeanFactory beanFactory = new XmlBeanFactory(r);

            Car car = (Car) beanFactory.getBean("car1");
            car.print();

            Car car2 =  (Car) beanFactory.getBean("car1");
            car.print();
        }
    }
}
