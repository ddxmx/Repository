package com.test.day03;

/**
 * 比较运算符
 * 比较运算符的结果都是boolean类型
 */
public class CompareOperDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 4;
        System.out.println(num1 > num2); //true
        System.out.println(num1 >= num2); //true
        System.out.println(num1 < num2); //false
        System.out.println(num1 <= num2); //false
        System.out.println(num1 == num2); //false
        System.out.println(num1 != num2); //true

        //7种基本数据类型和父子关系的引用数据类型才能进行==和!=的比较
        //System.out.println("10" != 10); //编译错误，String类型和int类型没有继承关系，不允许直接比较
        //System.out.println("10" == new Date()); //编译错误，String类型和Date类型没有继承关系，不允许直接比较
    }
}
