package com.test.oop.day07.access2;

import com.test.oop.day07.access1.AccessPrivateDemo;

/**
 * protected修饰的属性和方法，可以在不同包中的子类被访问
 * 只能通过super或子类对象来访问父类中protected成员
 */
public class AccessProtectedDemo extends AccessPrivateDemo {
    public void invoke() {
        // 在子类中使用super访问父类中protected的成员
        System.out.println(super.protectedVar);
        super.protectedMethod();
    }

    public static void main(String[] args) {
        AccessProtectedDemo demo = new AccessProtectedDemo();
        demo.invoke();

        // 在子类中使用子类对象访问父类中protected的成员
        System.out.println(demo.protectedVar);
        demo.protectedMethod();
    }
}
