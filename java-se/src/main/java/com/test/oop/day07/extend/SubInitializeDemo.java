package com.test.oop.day07.extend;

class SuperClass {
    private int superValue = 10;

    public SuperClass() {
        System.out.println(superValue);
        System.out.println("父类对象实例化");
        // 父类构造执行时，调用的父类方法被子类重写，实际上调用的是子类的方法，此时子类属性和构造都还没有执行，变量只是类型默认值
        test();
    }

    public void test() {
        System.out.println("SuperClass.test：" + superValue);
    }
}

class SubClass extends SuperClass {
    private int subValue = 20;

    public SubClass() {
        System.out.println(subValue);
        System.out.println("子类对象实例化");
    }

    /**
     * 覆写父类中的同名方法
     */
    @Override
    public void test() {
        System.out.println("SubClass.test：" + subValue);
    }
}

/**
 * 子类对象的实例化过程
 * 1、子类继承父类，继承了父类中的所有属性和方法
 * 2、子类实例化对象的过程：会依次调用父类的构造器(不会创建父类对象)，在堆内存中的子类对象中会存在所有父类的属性
 * 3、父类构造优先于子类构造执行，父类先于子类进行初始化属性和执行初始化方法
 */
public class SubInitializeDemo {
    public static void main(String[] args) {
        /*
            10
            父类对象实例化
            SubClass.test：0
            20
            子类对象实例化
         */
        new SubClass();
    }
}
