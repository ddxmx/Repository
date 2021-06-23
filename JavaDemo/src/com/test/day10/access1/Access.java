package com.test.day10.access1;

/**
 * 验证类、属性和方法的访问权限
 */
public class Access {
    private int privateVar;
    int defaultVar;
    public int publicVar;

    private void privateMethod() {
        //private属性可以在当前类中访问
        privateVar = 1;
        defaultVar = 2;
        publicVar = 3;
    }

    void defaultMethod() {
        privateVar = 1;
        defaultVar = 2;
        publicVar = 3;
    }

    public void publicMethod() {
        privateVar = 1;
        defaultVar = 2;
        publicVar = 3;
    }

    public void privateTest(){
        //private方法可以在当前类中访问
        privateMethod();
    }
}

class DefaultClass {
}
