package com.test.day01;

/**
 * @author gaoliang
 * @version 1.0
 * javadoc生成方式：Tools -> Generate JavaDoc
 * Locale:zh_CN
 * command line args:-encoding utf-8 -charset utf-8
 * public修饰的类名称和文件名称一致
 * 注释不会被编译
 */
public class HelloWorld01 {
    //主方法，程序的起点
    public static void main(String[] args) {
        /*
        多行注释不能嵌套使用
        System.out.println 打印后换行
        System.out.print 打印后不换行
         */
        System.out.print("Hello World !");
        System.out.println("Hello Java !");
    }
}

/**
 *  一个java源文件可以声明多个class，但只能有一个public class，编译后生成多个*.class文件
 */
class A{}

class B{}