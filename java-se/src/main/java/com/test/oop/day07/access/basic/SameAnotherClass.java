package com.test.oop.day07.access.basic;

/**
 * 同包不同类
 */
public class SameAnotherClass {
    public static void main(String[] args) {
        // public类可以被同包的其他类访问
        AccessBasicDemo demo = new AccessBasicDemo();

        // default类可以被同包的其他类访问
        new DefaultClass();

        // 验证属性
        // 编译错误，'privateVar' has private access，private属性无法在其他类中访问
        // System.out.println(demo.privateVar);
        System.out.println(demo.defaultVar);
        System.out.println(demo.protectedVar);
        System.out.println(demo.publicVar);

        // 验证方法
        // 编译错误，'privateMethod()' has private access，private方法无法在其他类中访问
        // demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
