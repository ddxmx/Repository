package com.test.oop.day07.access1;

/**
 * 验证类、属性和方法的访问权限
 */
public class AccessPrivateDemo {
    private int privateVar = 10;
    int defaultVar = 20;
    protected int protectedVar = 30;
    public int publicVar = 40;

    private void privateMethod() {
        System.out.println("AccessDemo.privateMethod");
    }

    void defaultMethod() {
        System.out.println("AccessDemo.defaultMethod");
    }

    protected void protectedMethod() {
        System.out.println("AccessDemo.protectedMethod");
    }

    public void publicMethod() {
        System.out.println("AccessDemo.publicMethod");
    }
}

/**
 * 缺省访问权限的类，只能被类所在包的其他类访问
 */
class DefaultClass {
}
