package com.test.jdk5.day16.annotation;

/**
 * 框架=注解+反射+设计模式
 * 常用的注解
 * |- Override：校验注解的方法是否覆写父类的方法
 * |- Deprecated：标记类或方法已经过期，类或方法可以正常使用，但是不建议再使用
 * |- SuppressWarnings：抑制编译器警告
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num = 10;
    }

    @Override
    public String toString() {
        return "AnnotationDemo.toString";
    }

    @Deprecated
    public static void test() {
        System.out.println("AnnotationDemo.test");
    }
}
