package com.test.oop.day07.access2;

import com.test.oop.day07.access1.Access;

/**
 * 验证不同包下类、属性和方法的访问权限
 */
public class AccessTest {
    public static void main(String[] args) {
        Access access = new Access();

        // 验证属性
        // 编译失败，'privateVar' has private access，private属性无法在其他类中访问
        // access.privateVar = 10;

        // 编译失败，'defaultVar' is not public，缺省属性无法在其他包中访问
        // access.defaultVar = 20;

        // 'protectedVar' has protected access，protected属性无法在其他包非子类中访问
        // access.protectedVar = 30;

        access.publicVar = 40;

        // 验证方法
        // 编译失败，'privateMethod()' has private access，private方法无法在其他类中访问
        // access.privateMethod();

        // 编译失败，'defaultMethod()' is not public，缺省方法无法在其他包中访问
        // access.defaultMethod();

        // 'protectedMethod()' has protected access，protected方法无法在其他包非子类中访问
        // access.protectedMethod();

        access.publicMethod();

        // 验证类
        // 编译失败，'com.test.oop.day10.access1.DefaultClass' is not public，缺省类无法在其他包中访问
        // DefaultClass defaultClass = new DefaultClass();
    }
}
