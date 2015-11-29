package org.china.framework.spring.model;

/**
 * Created by jeffrey on 15-11-11.
 */
public class Car {
    private String color;

    private String brand;

    private int price;

    public Car(){
        System.out.println("通过默认构造方法初始化");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("初始化color的值:" + color);
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.out.println("初始化price的值:" + price);
        this.price = price;
    }

    public Car(String color,int price){
        this.color = color;
        this.price = price;
        System.out.println("通过2个参数初始化Car");

    }

    public Car(String color,String brand,int price){
        this.color = color;
        this.price = price;
        this.brand = brand;
        System.out.println("通过3个参数初始化Car");
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("初始化brand的值:" + brand);
    }

    public void print(){
        System.out.println("汽车的颜色是:" + color + ",价格是:" + price + ",品牌是:" + brand);
    }
}
