package com.test.oop.day07.access2;

import com.test.oop.day07.access1.AccessPrivateDemo;

/**
 * 验证不同包下类、属性和方法的访问权限
 */
public class AccessPublicDemo {
    public static void main(String[] args) {
        AccessPrivateDemo demo = new AccessPrivateDemo();

        // 验证属性
        // 编译失败，'privateVar' has private access，private属性无法在其他类中访问
        // System.out.println(demo.privateVar);

        // 编译失败，'defaultVar' is not public，缺省属性无法在其他包中访问
        // System.out.println(demo.defaultVar);

        // 'protectedVar' has protected access，protected属性无法在其他包非子类中访问
        // System.out.println(demo.protectedVar);

        System.out.println(demo.publicVar);

        // 验证方法
        // 编译失败，'privateMethod()' has private access，private方法无法在其他类中访问
        // demo.privateMethod();

        // 编译失败，'defaultMethod()' is not public，缺省方法无法在其他包中访问
        // demo.defaultMethod();

        // 'protectedMethod()' has protected access，protected方法无法在其他包非子类中访问
        // demo.protectedMethod();

        demo.publicMethod();

        // 验证类
        // 编译失败，'com.test.oop.day07.access1.DefaultClass' is not public，缺省类无法在其他包中访问
        // new DefaultClass();
    }
}
