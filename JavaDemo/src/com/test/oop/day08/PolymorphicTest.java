package com.test.oop.day08;

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
 * 多态面试题
 * 向下转型是否成功，取决于实例类型是否是声明类型的子类
 */
public class PolymorphicTest {
    public static void main(String[] args) {
        // b实际上指向的实例是C类型
        B b = new C();
        // A和B接口实际上没有任何关系，但是因为类C同时是A和B类型的实现类，因此可以直接向下转型
        A a = (A) b;
        a.testA(); // C.testA
        System.out.println(a instanceof A); // true
        System.out.println(a instanceof B); // true
        System.out.println(a instanceof C); // true
        System.out.println(b instanceof A); // true
        System.out.println(b instanceof B); // true
        System.out.println(b instanceof C); // true
    }
}
