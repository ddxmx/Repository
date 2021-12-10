package com.test.oop.day07.access1;

/**
 * 验证类、属性和方法的访问权限
 */
public class Access {
    private int privateVar;
    int defaultVar;
    protected int protectedVar;
    public int publicVar;

    private void privateMethod() {
        // private属性可以在当前类中访问
        privateVar = 1;
        defaultVar = 2;
        protectedVar = 3;
        publicVar = 4;
    }

    void defaultMethod() {
        privateVar = 1;
        defaultVar = 2;
        protectedVar = 3;
        publicVar = 4;
    }

    protected void protectedMethod() {
        privateVar = 1;
        defaultVar = 2;
        protectedVar = 3;
        publicVar = 4;
    }

    public void publicMethod() {
        privateVar = 1;
        defaultVar = 2;
        protectedVar = 3;
        publicVar = 4;
    }

    public void privateTest() {
        // private方法可以在当前类中访问
        privateMethod();
    }
}

/**
 * 缺省访问权限的类，只能被类所在包的其他类访问
 */
class DefaultClass {
}
