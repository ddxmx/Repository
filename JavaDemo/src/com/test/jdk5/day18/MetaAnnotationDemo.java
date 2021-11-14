package com.test.jdk5.day18;

/**
 * 标记注解：注解内部没有定义任何属性，如Override
 * 元注解：对现有的注解进行解释说明的注解
 * 1、Retention；指定Annotation的生命周期
 * |- RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在，可以通过反射机制读取注解信息
 * |- RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * |- RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 2、Target：指定Annotation可以修饰的元素
 * |- ElementType.METHOD：方法声明
 * |- ElementType.TYPE：类、接口（包括注解类型）或enum声明
 * |- ElementType.FIELD：域声明（包括enum实例）
 * |- ElementType.CONSTRUCTOR：构造器的声明
 * |- ElementType.LOCAL_VARIABLE：局部变量声明
 * |- ElementType.PACKAGE：包声明
 * |- ElementType.PARAMETER：参数声明
 * 3、Documented：标识注解可以被生成在javadoc中，默认不生成
 * 4、Inherited：表示注解可以被子类继承，但这并不是真的继承，只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
 */
public class MetaAnnotationDemo {
}
