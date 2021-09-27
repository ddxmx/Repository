package com.test.oop.day10.access1;

/**
 * 验证同一个包下类、属性和方法的访问权限
 */
public class AccessDemo {
    public static void main(String[] args) {
        Access access = new Access();

        // 验证属性
        // access.privateVar = 10; // 编译失败，privateVar' has private access，private属性无法在其他类中访问
        access.defaultVar = 20;
        access.publicVar = 30;

        // 验证方法
        // access.privateMethod(); // 编译失败，privateMethod()' has private access，private方法无法在其他类中访问
        access.defaultMethod();
        access.publicMethod();
    }
}
