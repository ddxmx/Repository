package com.test.day22;

/**
 * 框架=注解+反射+设计模式
 * 常用的注解
 * 1、Override：校验注解的方法是否覆写父类的方法
 * 2、Deprecated：标记类或方法已经过期
 * 3、SuppressWarnings：抑制编译器警告
 */

public class AnnotationDemo {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num = 10;
    }

    @Override
    public String toString() {
        return "class_name:AnnotationDemo";
    }

    @Deprecated
    public static void fun() {
        System.out.println("hello world");
    }
}
