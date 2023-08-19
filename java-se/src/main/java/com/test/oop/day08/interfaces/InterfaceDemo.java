package com.test.oop.day08.interfaces;

/**
 * 接口
 * 1、接口组成结构：
 * （1）JDK7及之前：接口中只能定义全局常量和抽象方法
 * （2）JDK8：新增了static方法和default方法
 * （3）JDK9：新增了private方法
 * 2、接口中不能定义构造器，构造器主要为了给类中的成员变量初始化。接口中不存在成员变量，只存在全局常量
 * 3、类可以实现多个接口，弥补类的单继承局限性，class A implements B,C
 * 类同时继承父类和实现接口，class A extends B implements C
 * 接口和接口之间可以实现多继承 interface A extends B,C
 */
interface USB {
    // 全局常量，可以省略 public static final
    public static final String TYPE = "interface";

    // 抽象方法，可以省略 public abstract
    public abstract void start();

    // 接口中所有的方法都是public abstract修饰的
    void stop();
}

/**
 * 类实现接口，需要覆写接口中所有的抽象方法
 * 如果不覆写所有的抽象方法，类需要使用abstract修饰
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

class Keyboard implements USB {
    @Override
    public void start() {
        System.out.println("Keyboard.start");
    }

    @Override
    public void stop() {
        System.out.println("Keyboard.stop");
    }
}

class Computer {
    /**
     * 接口制定了统一标准，只要符合标准，都是接口的实现
     * 将方法的参数类型设置为接口类型，只要是接口的实现类，都可以传入
     * 参数的操作依赖接口提供的方法，因此接口的设计至关重要
     */
    public static void connect(USB usb) {
        usb.start();
        usb.stop();
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        /*
            Mouse.start
            Mouse.stop
         */
        Computer.connect(new Mouse());

        /*
            Keyboard.start
            Keyboard.stop
         */
        Computer.connect(new Keyboard());
    }
}
