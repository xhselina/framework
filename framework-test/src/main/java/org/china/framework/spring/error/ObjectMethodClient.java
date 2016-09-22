package org.china.framework.spring.error;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/22 14:51.
 */
public class ObjectMethodClient {
    public static void main(String[] args) {
        A a = new A();
        a.id = 1;
        a.name = "123" ;
        System.out.println(a.name);
        updateValue(a);
        System.out.println(a.name);

    }

    public static void updateValue(A a) {
        a.id = 100;
        a.name = "哈哈";
    }
}

class A{
    public int id;
    public String name;

}
