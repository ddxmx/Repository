package com.test.oop.day10.access2;

import com.test.oop.day10.access1.Access;

/**
 * 验证类、属性和方法的访问权限(不同包)
 */
public class AccessDemo {
    public static void main(String[] args) {
        Access access = new Access();

        //验证属性
        //access.privateVar = 10; //编译失败，privateVar' has private access，private属性无法在其他类中访问
        //access.defaultVar = 20; //编译失败，defaultVar' is not public，缺省属性无法在其他包中访问
        access.publicVar = 30;

        //验证方法
        //access.privateMethod(); //编译失败，privateMethod()' has private access，private方法无法在其他类中访问
        //access.defaultMethod(); //编译失败，defaultMethod()' is not public，缺省方法无法在其他包中访问
        access.publicMethod();

        //编译失败，'com.test.oop.day10.access1.DefaultClass' is not public，缺省类无法在其他包中访问
        //DefaultClass defaultClass = new DefaultClass();
    }
}
