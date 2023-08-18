package com.test.oop.day07.access.first;

/**
 * Public权限的类，可以被任何包中的类访问
 * 同一个类中，所有权限的成员都可以访问
 */
public class AccessPublicDemo {
    private int privateVar = 10;
    int defaultVar = 20;
    protected int protectedVar = 30;
    public int publicVar = 40;

    private void privateMethod() {
        System.out.println("PublicClass.privateMethod");
    }

    void defaultMethod() {
        System.out.println("PublicClass.defaultMethod");
    }

    protected void protectedMethod() {
        System.out.println("PublicClass.protectedMethod");
    }

    public void publicMethod() {
        System.out.println("PublicClass.publicMethod");
    }

    public static void main(String[] args) {
        AccessPublicDemo demo = new AccessPublicDemo();
        System.out.println(demo.privateVar);
        System.out.println(demo.defaultVar);
        System.out.println(demo.protectedVar);
        System.out.println(demo.publicVar);
        demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}

/**
 * 缺省访问权限的类，只能被相同包的其他类访问
 */
class DefaultClass {
}

