package com.test.oop.day14;

/**
 * final可以用来修饰类、属性、方法，表示最终的
 * 修饰类：类不能继承，比如系统中的 String类、包装类
 * 修饰变量：变量不可修改，包含成员变量、局部变量和方法的参数，基本数据类型值不能修改，引用数据类型地址不能修改
 * 修饰方法：方法不能被覆写
 */
public class FinalDemo {
    //全局常量
    public static final String YEAR = "2021";

    public static void main(String[] args) {
        final int num = 10;
        //num = 20; //编译失败，无法修改final修饰的变量

        final Order order = new Order();
        //order = new Order(); //编译失败，不能修改final修饰的引用类型的内存地址
        order.id = 20; //可以修改对象中的属性，此时内存地址不会修改
        System.out.println(order.id);
        // order.info = "hello"; //编译失败，final修饰的类中成员无法修改值
    }
}

class Order {
    int id = 10;

    //声明时或实例化前必须赋值，只能被赋值一次
    final String info;

    public Order() {
        info = "test";
    }
}
