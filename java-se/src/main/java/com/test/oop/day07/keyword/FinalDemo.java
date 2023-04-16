package com.test.oop.day07.keyword;

import java.util.Arrays;

/**
 * final可以用来修饰类、属性、方法，表示最终的
 * 修饰类：类不能被继承，比如String类、包装类等
 * 修饰变量（类中成员变量、方法中定义的变量和方法的参数）：变量不可修改（基本数据类型值不能修改，引用数据类型地址不能修改）
 * 修饰方法：方法不能被覆写
 */
public class FinalDemo {
    // 全局常量
    public static final String YEAR = "2023";

    public static void main(String[] args) {
        // 局部变量使用final修饰
        final int num = 10;
        // 编译错误，final修饰的变量即为常量，值不能被修改
        // num = 20;

        final int[] array = new int[3];
        System.out.println(Arrays.toString(array)); // [0, 0, 0]

        // 编译错误，不能修改final修饰的引用类型的内存地址
        // array = new int[5];

        // 不能修改引用指向的对象，但是可以修改对象中的属性
        array[0] = 10;
        System.out.println(Arrays.toString(array)); // [10, 0, 0]

        print(10); // 10
    }

    public static void print(final int value) {
        System.out.println(value);

        // 编译错误，final修饰方法的参数，方法中不能对参数进行修改
        // value = 100;
    }
}
