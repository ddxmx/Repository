package com.test.oop.day07.access.basic;

/**
 * 验证类、属性和方法的访问权限
 */
public class AccessBasicDemo {
    private int privateVar = 10;
    int defaultVar = 20;
    protected int protectedVar = 30;
    public int publicVar = 40;

    private void privateMethod() {
        System.out.println("AccessBasicDemo.privateMethod");
    }

    void defaultMethod() {
        System.out.println("AccessBasicDemo.defaultMethod");
    }

    protected void protectedMethod() {
        System.out.println("AccessBasicDemo.protectedMethod");
    }

    public void publicMethod() {
        System.out.println("AccessBasicDemo.publicMethod");
    }
}

/**
 * 缺省访问权限的类，只能被类所在包的其他类访问
 */
class DefaultClass {
}
