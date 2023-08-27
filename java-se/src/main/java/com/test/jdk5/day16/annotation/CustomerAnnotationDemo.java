package com.test.jdk5.day16.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 注解使用 @interface声明
 * 1、自定义注解默认自动继承了java.lang.annotation.Annotation接口
 * 2、Annotation约定的定义方式就是从interface演化而来，然而其中注解的属性通过接口的方法来定义。
 * 从来没有见过接口中可以定义属性，都是方法；而且方法都是有返回值的。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CustomerAnnotation {
    /*
        1、如果注解内没有成员，表示一个标识注解
        2、内部只有一个成员时，通常使用名称value
        3、使用default表示默认值
        4、注解中使用方法来定义属性
        5、注解支持的元素的数据类型如下，不允许使用任何包装类
        （1）所有基本类型（byte,short,int,long,float,double,char,boolean）
        （2）String
        （3）Class
        （4）enum
        （5）Annotation
        （6）上述类型的数组
     */
    // 没有默认值，代表后续使用注解时必须给该类型元素赋值
    String value();

    String desc() default "";

    // 数组类型注解元素，@注解名(类型名 = 类型值)，它和标准写法：@注解名(类型名 = {类型值})等效
    int[] score() default {0, 0, 0};
}

/**
 * 自定义注解
 */
public class CustomerAnnotationDemo {
    public static void main(String[] args) {
        // 利用反射获取到方法
        Method[] methods = CustomerAnnotationDemo.class.getMethods();

        for (Method method : methods) {
            // 注解必须是RUNTIME声明周期，运行时才可以获取到
            // 判断方法上是否存在此注解
            if (method.isAnnotationPresent(CustomerAnnotation.class)) {
                // 获取注解对象
                CustomerAnnotation myAnnotation = method.getAnnotation(CustomerAnnotation.class);
                System.out.println(myAnnotation.value());
                System.out.println(myAnnotation.desc());
                System.out.println(Arrays.toString(myAnnotation.score()));
            }
        }
    }

    // @MyAnnotation("hello")
    // @MyAnnotation(value = "hello")
    @CustomerAnnotation(value = "hello", score = {95, 92, 100})
    public static void test() {
    }
}
