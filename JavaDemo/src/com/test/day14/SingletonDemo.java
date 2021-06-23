package com.test.day14;

/**
 * 单例设计模式
 * 分为饿汉式和懒汉式
 * 饿汉式：类加载的时候对象就创建；线程安全的
 * 懒汉式：(懒加载)，非线程安全的
 * java.lang.Runtime类就是单例的
 */
class Singleton {
    //饿汉式
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void show() {
        System.out.println("hello world");
    }
}

//class Singleton {
//    private static Singleton instance;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        //懒汉式
//        if (null == instance) {
//            instance = new Singleton();
//        }
//
//        return instance;
//    }
//
//    public void show() {
//        System.out.println("hello world");
//    }
//}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instanceA = Singleton.getInstance();
        instanceA.show(); //hello world
        Singleton instanceB = Singleton.getInstance();
        instanceB.show(); //hello world
        System.out.println(instanceA == instanceB); //true
    }
}
