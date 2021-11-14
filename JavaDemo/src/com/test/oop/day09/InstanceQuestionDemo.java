package com.test.oop.day09;

class Base {
    public Base() {
        test();
    }

    public void test() {
    }
}

class Child extends Base {
    private int num = 123;

    public Child() {
    }

    public void test() {
        System.out.println(num);
    }
}

/**
 * 对象实例化过程面试题
 */
public class InstanceQuestionDemo {
    public static void main(String[] args) {
        /*
            子类对象的实例化过程中，先调用父类构造
            父类构造执行时，调用的父类方法被子类重写时，实际上调用的是子类的方法
            子类方法执行时，此时子类属性和构造都还没有执行，变量只是默认值
         */
        Child child = new Child(); // 0
        System.out.println("************************");
        // 对象实例化完成后，对象中属性值是指定的值
        child.test(); // 123
    }
}
