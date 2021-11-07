package com.test.oop.day12.access1;

/**
 * 验证protected的访问权限
 * 为什么要设计protected访问权限？
 * 1、protected方法希望被子类覆写，但不希望被其他类独立调用
 * 2、父类不希望定义成抽象类或接口（无法独立实例化），父类需要作为一个普通的类使用
 * 模板设计模式（父类不一定是抽象类）是protected常见的使用场景
 */
public class Access {
    protected int protectedVar;
    int defaultVar;

    protected void protectedMethod() {
        protectedVar = 100;
        System.out.println("protected method：" + protectedVar);
    }

    void defaultMethod() {
        defaultVar = 200;
        System.out.println("default method：" + defaultVar);
    }
}

class ProtectedDemo {
    public static void main(String[] args) {
        Access access = new Access();
        // default属性在同一个包中可以直接通过对象方法
        System.out.println(access.defaultVar); // 0
        access.defaultMethod(); // default method：200
    }
}
