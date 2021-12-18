package com.test.oop.day09;

/**
 * final可以用来修饰类、属性、方法，表示最终的
 * 修饰类：类不能被继承，比如String类、包装类等
 * 修饰变量（成员变量、局部变量和方法的参数）：变量不可修改，基本数据类型值不能修改，引用数据类型地址不能修改
 * 修饰方法：方法不能被覆写
 */
public class FinalDemo {
    // 全局常量
    public static final String YEAR = "2021";

    /**
     * 静态私有内部类，类无法被外部访问，不需要实例化外部类就可以访问内部类
     */
    private static class Order {
        int id = 10;

        // final修饰的成员变量，声明时或实例化前必须赋值，且只能被赋值一次
        final String info;

        public Order() {
            info = "test";
        }
    }

    public static void main(String[] args) {
        // 局部变量使用final修饰
        final int num = 10;
        // 编译失败，final修饰的变量即为常量，值不能被修改
        // num = 20;

        final Order order = new Order();
        // 编译失败，不能修改final修饰的引用类型的内存地址
        // order = new Order();
        // 不能修改引用指向的对象，但是可以修改对象中的属性
        order.id = 20;
        System.out.println(order.id); // 20
        // 编译失败，final修饰的类中成员无法修改
        // order.info = "hello";

        print(10); // 10
    }

    public static void print(final int value) {
        System.out.println(value);

        // 编译失败，final修饰方法的参数，方法中不能对参数进行修改
        // value = 100;
    }
}


