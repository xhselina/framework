package org.china.framework.spring.pattern.享元模式;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/4/11 9:00.
 */
public class Client {
    public static void main(String[] args) {
        FlywightFactory flywightFactory = new FlywightFactory();
        long start = System.currentTimeMillis();
        for(int i=0; i<1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ConcreteFlyweight flyweight = (ConcreteFlyweight) flywightFactory.getFlyweight("x");
                    flyweight.operation("1");
                }
            }).start();
        }
        long end = System.currentTimeMillis();

        System.out.println(Double.valueOf((end - start)/1000));




    }
}
