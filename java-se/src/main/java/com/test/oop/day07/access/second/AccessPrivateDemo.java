package com.test.oop.day07.access.second;

import com.test.oop.day07.access.first.AccessPublicDemo;

/**
 * 不同包非子类
 */
public class AccessPrivateDemo {
    public static void main(String[] args) {
        AccessPublicDemo demo = new AccessPublicDemo();

        // 验证属性
        // 编译错误，'privateVar' has private access，private属性无法在其他类中访问
        // System.out.println(demo.privateVar);

        // 编译错误，'defaultVar' is not public，缺省属性无法在其他包中访问
        // System.out.println(demo.defaultVar);

        // 编译错误，'protectedVar' has protected access，protected属性无法在其他包非子类中使用父类对象访问
        // System.out.println(demo.protectedVar);

        // 编译错误，protected属性无法在其他包非子类中使用子类对象访问
        // System.out.println(new AccessProtectedDemo().protectedVar);

        System.out.println(demo.publicVar);

        // 验证方法
        // 编译错误，'privateMethod()' has private access，private方法无法在其他类中访问
        // demo.privateMethod();

        // 编译错误，'defaultMethod()' is not public，缺省方法无法在其他包中访问
        // demo.defaultMethod();

        // 编译错误，'protectedMethod()' has protected access，protected方法无法在其他包非子类中使用父类对象访问
        // demo.protectedMethod();

        // 编译错误，protected方法无法在其他包非子类中使用子类对象访问
        // System.out.println(new AccessProtectedDemo().protectedMethod());

        demo.publicMethod();

        // 验证类
        // 编译错误，default类不允许被其他包中类访问
        // new DefaultClass();
    }
}
