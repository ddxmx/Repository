package com.test.oop.day08.access2;

import com.test.oop.day08.access1.Access;

/**
 * protected修饰的属性和方法，可以在不同包中的子类被访问，只能通过子类或子类的引用来访问父类中protected成员。
 */
public class SubAccess extends Access {
    public void invoke() {
        // 在子类中访问父类中protected的成员
        super.protectedVar = 1;
        super.protectedMethod();

        // defaultVar = 20; // 编译错误，包访问权限，其他包不可见
        // defaultMethod(); // 编译错误，包访问权限，其他包不可见
    }

    public static void main(String[] args) {
        SubAccess access = new SubAccess();
        // 通过子类的引用访问protected成员
        access.protectedVar = 10;
        // access.defaultVar = 20; // 编译失败，缺省的权限不能在包外访问，'defaultVar' is not public
        access.protectedMethod(); // protected method：100
        // access.defaultMethod(); // 编译失败，缺省的权限不能在包外访问，'defaultMethod()' is not public
    }
}
