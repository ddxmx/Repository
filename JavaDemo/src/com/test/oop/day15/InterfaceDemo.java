package com.test.oop.day15;

interface USB {
    // 全局常量，可以省略 public static final
    public static final String TYPE = "interface";

    // 抽象方法，可以省略 public abstract
    public abstract void start();

    void stop();
}

/**
 * 类实现接口，覆写接口中所有的抽象方法
 */
class Mouse implements USB {
    @Override
    public void start() {
        System.out.println("Mouse.start");
    }

    @Override
    public void stop() {
        System.out.println("Mouse.stop");
    }
}

class keyboard implements USB {
    @Override
    public void start() {
        System.out.println("keyboard.start");
    }

    @Override
    public void stop() {
        System.out.println("keyboard.stop");
    }
}

class Computer {
    /**
     * 接口制定了统一标准，只要符合标准，都可以通过参数传入
     * 方法中的实现依赖接口提供的方法，因此接口的设计至关重要
     */
    public static void work(USB usb) {
        usb.start();
        usb.stop();
    }
}

/**
 * 不同版本下接口结构组成：
 * |- JDK7及之前：接口中只能定义全局常量和抽象方法
 * |- JDK8：新增了static方法和default方法
 * |- JDK9：新增了private方法
 * 接口中不能定义构造器，构造器主要为了给类中的成员变量初始化。接口中不存在成员变量，只存在全局常量
 * 类可以实现多个接口，弥补了类的单继承局限性，class A implements B,C
 * 类同时继承类和实现接口，class A extends B implements C
 * 接口和接口之间可以实现多继承 interface A extends B,C
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        /*
            Mouse.start
            Mouse.stop
         */
        Computer.work(new Mouse());

        /*
            keyboard.start
            keyboard.stop
         */
        Computer.work(new keyboard());
    }
}
