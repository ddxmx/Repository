package com.test.day12;

class SuperClass {
    private int superValue = 10;

    public SuperClass() {
        System.out.println(superValue);
        System.out.println("父类对象实例化");
    }
}

class SubClass extends SuperClass {
    private int subValue = 20;

    public SubClass() {
        System.out.println(subValue);
        System.out.println("子类对象实例化");
    }
}

/**
 * 子类继承父类，就继承了父类中的所有属性和方法
 * 子类实例化对象的过程，会依次调用父类的构造器(不会创建父类对象)，在堆内存中的子类对象中会存在所有父类的属性
 * 父类构造优先于子类构造执行
 */
public class InstanceDemo {
    public static void main(String[] args) {
        /*
            10
            父类对象实例化
            20
            子类对象实例化
        */
        new SubClass();
    }
}
