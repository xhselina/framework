package org.china.framework.spring.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/23 15:11.
 */
public class Client {
    public static void main(String[] args) throws  Exception {
        // 获取Class对象的3中方法
        Class class1 = Employment.class;
        System.out.println(class1.getName());

        Class class2 = new Employment().getClass();
        System.out.println(class2.getName());

        Class class3 = Class.forName("org.china.framework.spring.reflect.Employment");

        // 获取所有方法
        Method[] methods = class1.getMethods();
        System.out.println(Arrays.toString(methods));

        // 实例化
        Employment e = (Employment) class1.newInstance();

        Method method = class1.getMethod("setId",new Class[]{Long.class});

        Object mo = method.invoke(e,12345l);
        System.out.println(e.getId());
        method = class1.getMethod("getName");
        mo = method.invoke(e);
        System.out.println(e.getName());

        // 获取构造函数
        Constructor[] constructors = class1.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Constructor constructor = class1.getConstructor(new Class[]{Long.class,String.class});
        constructor.setAccessible(true);
        Employment o = (Employment) constructor.newInstance(new Object[]{1234L,"哈哈"});
        Field field = class1.getDeclaredField("createTime");
        field.setAccessible(true);
        field.set(o,new Date());

        System.out.println(o.toString());

        constructor.setAccessible(true);



    }
}
