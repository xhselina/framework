package org.china.framework.spring.pattern.builder;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/30 13:11.
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        for (int i=0; i<10; i++){
            director.buildBenH1().run();
        }

        for (int i=0; i<10; i++){
            director.buildBMWH2().run();
        }
    }
}
