package com.test.jdk5.day16.annotation;

/**
 * 注解分为标记注解和元注解
 * 1、标记注解：注解内部没有定义任何属性，如Override
 * 2、元注解：对现有的注解进行解释说明的注解
 * (1)、@Retention；指定Annotation的生命周期
 * （A）@Retention(RetentionPolicy.RUNTIME)：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在，可以通过反射机制读取注解信息
 * （B）@Retention(RetentionPolicy.SOURCE)：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃
 * （C）@Retention(RetentionPolicy.CLASS)（默认）：注解被保留到class文件，但jvm加载class文件时候被遗弃
 * (2)、@Target：注解的作用目标
 * （A）@Target(ElementType.TYPE)：接口、类、枚举、注解
 * （B）@Target(ElementType.FIELD)：字段、枚举的常量
 * （C）@Target(ElementType.METHOD)：方法
 * （D）@Target(ElementType.CONSTRUCTOR)：构造方法
 * （E）@Target(ElementType.LOCAL_VARIABLE)：局部变量
 * （F）@Target(ElementType.PACKAGE)：包
 * （G）@Target(ElementType.PARAMETER)：方法参数
 * (3)、@Documented：标识注解可以被生成在javadoc中，默认不生成
 * (4)、@Inherited：表示注解可以被子类继承，但这并不是真的继承，只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
 * (5)、@Repeatable：表示注解可以重复使用，为了解决同一个注解不能重复在同一类/方法/属性上使用的问题
 */
public class MetaAnnotationDemo {
}
