package com.test.basic.day01;

/**
 * @author yu
 * @version 1.0
 * <p>
 * javadoc生成方式：Tools -> Generate JavaDoc
 * Locale:zh_CN
 * Other command line arguments:-encoding utf-8 -charset utf-8
 * <p>
 * java文件名称必须和public修饰的类名称保持一致
 * 注释不会被编译，分为三种：单行注释、多行注释、文档注释
 */
public class HelloWorld {
    // 单行注释，主方法，程序的起点
    public static void main(String[] args) {
        /*
            多行注释不能嵌套使用，可以编写多行
            System.out.println 输出后换行
            System.out.print 输出后不换行
            System.out.printf 格式化输出，输出后不换行

            运行结果：
            Hello World!Hello Java!

            Hello China!
            I am Jerry,my age is 24,my salary is 8000.5
        */
        System.out.print("Hello World!");
        System.out.println("Hello Java!");
        System.out.println(); // 输出空行
        System.out.println("Hello China!");
        // %s表示字符串格式化，%d表示整数格式化，%f表示小数格式化
        System.out.printf("I am %s,my age is %d,my salary is %.1f", "Jerry", 24, 8000.45);
    }
}

/**
 * 一个java源文件可以定义多个class，编译后根据class名称生成多个*.class文件
 * 一个java源文件只能定义一个public class，java文件名称必须和public class类名称一致
 */
class A {
}

class B {
}