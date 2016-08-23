package org.china.framework.spring.alltype;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/8/18 8:46.
 */
public class Client  {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
        Point<Integer,Integer> point = new Point<>();
        point.setX(10);
        point.setY(20);
        logger.info(ToStringBuilder.reflectionToString(point));
        point.print(point.getX(),point.getY());

        Point<Double,String> point1 = new Point<>() ;
        point1.setX(25.0);
        point1.setY("adf");
        point1.print(point1.getX(),point1.getY());

        Info<String> obj = new InfoImpl<>();
        System.out.println(obj.getValue());
    }
}

interface Info<T>{
    T getValue() ;
}

class InfoImpl<T> implements Info<T>{
     T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public T getValue() {
        return t;
    }
}

class Point<X,Y>{
    X x;
    Y y;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public void print(X x,Y y){
//        X x1 = x;
//        Y y1 = y;
        System.out.println(x + "," + y);
    }
}