package com.test.oop.day07.access2;

import com.test.oop.day07.access1.Access;

/**
 * protected修饰的属性和方法，可以在不同包中的子类被访问
 * 只能通过子类或子类的引用来访问父类中protected成员
 */
public class SubAccess extends Access {
    public void invoke() {
        // 在子类中使用super访问父类中protected的成员
        super.protectedVar = 100;
        super.protectedMethod();
    }

    public static void main(String[] args) {
        SubAccess access = new SubAccess();
        access.invoke();

        // 在子类中使用子类对象访问父类中protected的成员
        access.protectedVar = 200;
        access.protectedMethod();
    }
}
