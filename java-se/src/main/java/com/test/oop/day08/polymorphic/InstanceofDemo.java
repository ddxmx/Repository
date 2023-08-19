package com.test.oop.day08.polymorphic;

interface SuperA {
    public void testA();
}

interface SuperB {
    public void testB();
}

/**
 * 类 Sub是接口SuperA、SuperB的实现类
 * Sub的实例可以使用SuperA或SuperB类型的引用接收
 */
class Sub implements SuperA, SuperB {
    @Override
    public void testA() {
        System.out.println("Sub.testA");
    }

    @Override
    public void testB() {
        System.out.println("Sub.testB");
    }
}

/**
 * 向下转型使用instanceof进行安全转型的判断
 * a instanceof A：对象a是否是类A的实例
 */
public class InstanceofDemo {
    public static void main(String[] args) {
        // superA实际上指向的实例是Sub类型
        SuperA superA = new Sub();

        // SuperA和SuperB接口实际上没有任何关系，但是因为类Sub同时是SuperA和SuperB类型的实现类，因此可以直接转型
        SuperB superB = (SuperB) superA;

        superB.testB(); // Sub.testB
        // 编译失败，可以调用的方法由声明类型决定
        // superB.testA();

        System.out.println(superA instanceof SuperA); // true
        System.out.println(superA instanceof SuperB); // true
        System.out.println(superA instanceof Sub); // true

        System.out.println(superB instanceof SuperA); // true
        System.out.println(superB instanceof SuperB); // true
        System.out.println(superB instanceof Sub); // true
    }
}
