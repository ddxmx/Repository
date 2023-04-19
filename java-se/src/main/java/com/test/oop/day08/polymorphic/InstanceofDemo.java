package com.test.oop.day08.polymorphic;

interface A {
    public void testA();
}

interface B {
    public void testB();
}

/**
 * 类 C是接口A、B的实现类
 * C的实例可以使用A或B类型的引用接收
 */
class C implements A, B {
    @Override
    public void testA() {
        System.out.println("C.testA");
    }

    @Override
    public void testB() {
        System.out.println("C.testB");
    }
}

/**
 * 向下转型
 * 使用instanceof进行安全转型的判断
 * a instanceof A：对象a是否是类A的实例
 */
public class InstanceofDemo {
    public static void main(String[] args) {
        // b实际上指向的实例是C类型
        B b = new C();

        // A和B接口实际上没有任何关系，但是因为类C同时是A和B类型的实现类，因此可以直接转型
        A a = (A) b;

        a.testA(); // C.testA
        // 编译失败，可以调用的方法由声明类型决定
        // a.testB();

        System.out.println(a instanceof A); // true
        System.out.println(a instanceof B); // true
        System.out.println(a instanceof C); // true
        System.out.println(b instanceof A); // true
        System.out.println(b instanceof B); // true
        System.out.println(b instanceof C); // true
    }
}
