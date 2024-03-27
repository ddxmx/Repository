package com.test.basic.day01;

/**
 * 第一个java程序：HelloWorld
 *
 * @author yu
 * @version 1.0
 * 注释不会被编译，分为三种：单行注释、多行注释、文档注释
 * 文档注释可以使用在类、属性或方法上，以"/**"开头，"*斜杠"结尾
 */
public class HelloWorld01 {
    // 单行注释，//后的内容都是注释，注释不能跨行
    // main方法是程序的起点，String[] args表示使用数组接收命令行参数
    public static void main(String[] args) {
        /*
            多行注释以"/*"开头，"*斜杠"结尾
            多行注释不能够嵌套使用，注释内容可以有多行
            System.out.println：输出后换行（print + line）
            System.out.print：输出后不换行
            System.out.printf：格式化输出，输出后不换行（print + format）
        */

        /*
            运行结果：
            Hello World!Hello Java!

            name is Jerry,age is 24,salary is   8000.5
            name is Jerry,age is 24,salary is   8000.5
         */
        System.out.print("Hello World!");
        System.out.println("Hello Java!");
        System.out.println(); // 输出空行

        // %s表示字符串格式化，%d表示整数格式化
        // %f表示小数格式化，%8.1f表示8位长度，小数占1位，不足左边补空格，小数会进行四舍五入
        String formatStr = "name is %s,age is %d,salary is %8.1f\n";
        System.out.printf(formatStr, "Jerry", 24, 8000.45); // 左边补2个空格
        // String.format方法和printf方法格式化后的结果一致
        System.out.println(String.format(formatStr, "Jerry", 24, 8000.45));

        // 不存在主方法的类，不能够直接运行，但是可以被其他类调用
        new A();
    }
}

/**
 * 一个java源文件只能定义一个public class，java文件名称必须和public class类名称一致
 * 一个java源文件可以定义多个class，编译后根据class名称生成不同的class文件
 * 当前文件编译后会生成三个class文件，HelloWorld.class、A.class、B.class
 * HelloWorld.class中存在main方法，称为主类，可以直接执行
 * A.class、B.class中不存在main方法，不能直接运行，但是可以被其他类调用
 */
class A {
}

class B {
}