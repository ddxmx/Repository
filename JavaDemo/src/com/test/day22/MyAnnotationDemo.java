package com.test.day22;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 注解使用 @interface声明
 * Annotation约定的定义方式就是从interface演化而来，然而其中注解的属性通过接口的方法来定义。
 * 从来没有见过接口中可以定义属性，都是方法；而且方法都是有返回值的。
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    //如果注解内没有成员，表示一个标识注解

    //内部只有一个成员时，通常使用名称value

    //使用default表示默认值
    //注解中使用方法来定义属性
    /*
        注解支持的元素的数据类型如下，不允许使用任何包装类
        1、所有基本类型（byte,short,int,long,float,double,char,boolean）
        2、String
        3、Class
        4、enum
        5、Annotation
        6、上述类型的数组
     */
    String value() default "test";
}

/**
 * 自定义注解
 */
public class MyAnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        //利用反射获取到方法
        Class<MyAnnotationDemo> demoClass = MyAnnotationDemo.class;
        Method method = demoClass.getMethod("fun");

        //注解必须是RUNTIME声明周期，运行时才可以获取到
        //判断方法上是否存在此注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            ///获取注解对象
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.value()); //hello
        }
    }

    //@MyAnnotation("hello")
    //@MyAnnotation
    @MyAnnotation(value = "hello")
    public static void fun() {
    }
}
