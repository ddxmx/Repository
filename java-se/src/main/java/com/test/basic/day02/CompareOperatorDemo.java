package com.test.basic.day02;

/**
 * 比较运算符
 * 比较运算符的结果都是boolean类型
 * 其中 >、>=、<、<=都是数值比较
 * ==和!=除了可以进行数值比较外，还可以进行引用数据类型内存地址比较
 */
public class CompareOperatorDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 4;
        System.out.println(num1 > num2); // true
        System.out.println(num1 >= num2); // true
        System.out.println(num1 < num2); // false
        System.out.println(num1 <= num2); // false
        System.out.println(num1 == num2); // false
        System.out.println(num1 != num2); // true

        // 7种基本数值类型和存在父子关系的引用数据类型才能使用==和!=进行比较
        String str = "hello";
        Object obj = str;
        System.out.println(str == obj); // true
        System.out.println(str != obj); // false

        // 编译错误，String类型和int类型没有父子关系，不允许直接比较
        // System.out.println("10" != 10);
    }
}
