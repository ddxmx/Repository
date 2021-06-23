package com.test.day15;

interface USB {
    //全局常量，可以省略public static final
    public static final String TYPE = "interface";

    public abstract void start();

    void stop();
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作");
    }
}

class Computer {
    public static void work(USB usb) {
        usb.start();
        usb.stop();
    }
}

/**
 * interface描述接口
 * JDK7及之前：接口中只能定义全局常量和抽象方法
 * JDK8：新增了static方法和default方法
 * JDK9：新增了private方法
 * 接口中不能定义构造器
 * 类可以实现多个接口，弥补了类的单继承 class A implements B,C
 * 同时继承类和实现接口，class A extends B implements C
 * 接口和接口之间可以实现多继承 interface A extends B,C
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        /*
            打印机开始工作
            打印机停止工作
         */
        Computer.work(new Printer());
        /*
            手机已连接
            手机断开连接
         */
        Computer.work(new USB() {
            @Override
            public void start() {
                System.out.println("手机已连接");
            }

            @Override
            public void stop() {
                System.out.println("手机断开连接");
            }
        });
    }
}
