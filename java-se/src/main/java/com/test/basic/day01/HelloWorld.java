package com.test.basic.day01;

/**
 * @author yu
 * @version 1.0
 * 注释不会被编译，分为三种：单行注释、多行注释、文档注释
 */
public class HelloWorld {
    // 单行注释，//后的内容都是注释，不能跨行
    // main方法是程序的起点，String[] args表示使用数组接收命令行参数
    public static void main(String[] args) {
        /*
            多行注释不能嵌套使用，注释内容可以有多行
            System.out.println 输出后换行（print + line）
            System.out.print 输出后不换行
            System.out.printf 格式化输出，输出后不换行（print + format）
        */
        /*
            运行结果：
            Hello World!Hello Java!

            Hello China!
            name is Jerry,age is 24,salary is   8000.5
            name is Jerry,age is 24,salary is   8000.5
         */
        System.out.print("Hello World!");
        System.out.println("Hello Java!");
        System.out.println(); // 输出空行
        System.out.println("Hello China!");
        // %s表示字符串格式化，%d表示整数格式化，%f表示小数格式化，%8.1f表示8位长度，小数占1位，不足左边补空格
        System.out.printf("name is %s,age is %d,salary is %8.1f", "Jerry", 24, 8000.45);
        System.out.println();
        // String.format和printf格式化后的结果一致
        System.out.println(String.format("name is %s,age is %d,salary is %8.1f", "Jerry", 24, 8000.45));
    }
}

/**
 * 一个java源文件只能定义一个public class，java文件名称必须和public class类名称一致
 * 一个java源文件可以定义多个class，编译后根据class名称生成不同的class文件
 * 当前文件编译后会生成3个class文件，HelloWorld.class、A.class、B.class
 * HelloWorld.class中存在main方法，称为主类，可以直接执行
 * A.class、B.class中不存在main方法，不能直接执行，但是可以被其他类调用
 */
class A {
}

class B {
}