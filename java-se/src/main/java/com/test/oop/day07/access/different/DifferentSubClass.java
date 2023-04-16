package com.test.oop.day07.access.different;

import com.test.oop.day07.access.basic.AccessBasicDemo;

/**
 * 不同包子类
 * protected修饰的属性和方法，访问约束
 * |- 在子类中，使用super访问
 * |- 在子类中，使用子类对象访问
 * |- 在子类中，使用父类对象无法访问
 * |- 在非子类中，使用父类或子类对象都无法访问
 */
public class DifferentSubClass extends AccessBasicDemo {
    public void protectedTest() {
        // 在子类中使用super访问父类中protected的成员
        System.out.println(super.protectedVar);
        super.protectedMethod();
    }

    public static void main(String[] args) {
        // 创建子类对象
        DifferentSubClass demo = new DifferentSubClass();
        demo.protectedTest();

        // 在子类中使用子类对象访问父类中protected的成员
        System.out.println(demo.protectedVar);
        demo.protectedMethod();

        // 在子类中使用父类对象无法访问父类中protected的成员
        AccessBasicDemo accessBasicDemo = new AccessBasicDemo();
        // System.out.println(accessBasicDemo.protectedVar);
        // accessBasicDemo.protectedMethod();
    }
}
