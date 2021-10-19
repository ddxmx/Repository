package com.test.oop.day12.access2;

/**
 * 非子类中protected属性和方法的访问
 */
public class NotSubAccessDemo {
    public static void main(String[] args) {
        SubAccess access = new SubAccess();

        // protected属性只能在子类中通过子类对象方法，其他包非子类无法访问
        // access.protectedVar = 10;

        // protected方法只能在子类中通过子类对象方法，其他包非子类无法访问
        // access.protectedMethod();
    }
}
