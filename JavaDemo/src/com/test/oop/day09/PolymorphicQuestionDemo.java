package com.test.oop.day09;

interface A {
}

interface B {
}

/**
 * 类 C是接口A、B的实现类
 * C的实例可以使用A或B类型的引用接收
 */
class C implements A, B {
}

/**
 * 多态面试题
 * 向下转型是否成功，取决于实例类型是否是声明类型的子类
 */
public class PolymorphicQuestionDemo {
    public static void main(String[] args) {
        // b实际上指向的实例是C类型
        B b = new C();
        // A和B接口实际上没有任何关系，但是因此实例是C，因此可以直接向下转型
        A a = (A) b;
        System.out.println(a);
    }
}
