package com.test.oop.day07.access1;

/**
 * 验证同一个包下类、属性和方法的访问权限
 */
public class AccessTest {
    public static void main(String[] args) {
        Access access = new Access();

        // 验证属性
        // 编译失败，'privateVar' has private access，private属性无法在其他类中访问
        // access.privateVar = 10;
        access.defaultVar = 20;
        access.protectedVar = 30;
        access.publicVar = 40;

        // 验证方法
        // 编译失败，'privateMethod()' has private access，private方法无法在其他类中访问
        // access.privateMethod();
        access.defaultMethod();
        access.protectedMethod();
        access.publicMethod();

        // 验证default类
        DefaultClass defaultClass = new DefaultClass();
    }
}
