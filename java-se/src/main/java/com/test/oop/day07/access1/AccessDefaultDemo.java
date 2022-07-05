package com.test.oop.day07.access1;

/**
 * 验证同一个包下类、属性和方法的访问权限
 */
public class AccessDefaultDemo {
    public static void main(String[] args) {
        AccessPrivateDemo demo = new AccessPrivateDemo();

        // 验证属性
        // 编译失败，'privateVar' has private access，private属性无法在其他类中访问
        // System.out.println(demo.privateVar);
        System.out.println(demo.defaultVar);
        System.out.println(demo.protectedVar);
        System.out.println(demo.publicVar);

        // 验证方法
        // 编译失败，'privateMethod()' has private access，private方法无法在其他类中访问
        // demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();

        // 验证default类，default类可以在当前包中其他类访问
        new DefaultClass();
    }
}
