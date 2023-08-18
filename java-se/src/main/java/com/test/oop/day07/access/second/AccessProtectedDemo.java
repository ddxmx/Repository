package com.test.oop.day07.access.second;

import com.test.oop.day07.access.first.AccessPublicDemo;

/**
 * 不同包的子类
 * 父类中protected修饰的属性和方法，访问约束
 * （1）在子类中，使用super访问
 * （2）在子类中，使用子类对象访问
 * （3）在子类中，使用父类对象无法访问
 * （4）在非子类中，使用父类或子类对象都无法访问
 */
public class AccessProtectedDemo extends AccessPublicDemo {
    public void protectedTest() {
        // 在子类中使用super访问父类中protected的成员
        System.out.println(super.protectedVar);
        super.protectedMethod();
    }

    public static void main(String[] args) {
        // 创建子类对象
        AccessProtectedDemo demo = new AccessProtectedDemo();
        demo.protectedTest();

        // 在子类中使用子类对象访问父类中protected的成员
        System.out.println(demo.protectedVar);
        demo.protectedMethod();

        // 在子类中使用父类对象无法访问父类中protected的成员
        AccessPublicDemo accessPublicDemo = new AccessPublicDemo();
        // System.out.println(accessBasicDemo.protectedVar);
        // accessBasicDemo.protectedMethod();
    }
}
