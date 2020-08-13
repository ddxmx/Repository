package com.test.day06;

import java.util.Arrays;

/**
 * 数组是引用数据类型，是一组数据的集合
 * 内存中一块连续的区域，使用头指针查找
 * 数组的长度固定
 */
public class ArrayDemo01 {
    public static void main(String[] args) {
        //静态初始化方式一，推荐方式
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        //静态初始化方式二
        String[] array2 = {"hello", "world", "java"};

        //动态初始化，元素的初始值为元素数据类型的默认值
        int[] arr = new int[3];
        //元素的索引位置： 0 ~ 数组长度-1
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        //arr[3] = 40; //编译通过，运行报错，索引越界 ArrayIndexOutOfBoundsException

        //数组长度
        System.out.println(arr.length); // 3

        //遍历数组元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", "); // 10, 20, 30,
        }
        System.out.println();

        //Arrays类也为数组提供支持
        System.out.println(Arrays.toString(arr)); //[10, 20, 30]

        int[] arr2 = new int[]{1, 2, 3};
        arr2[1] = 20; //修改堆内存空间的值
        arr2 = new int[5]; //更改指向的堆内存空间，原堆内存空间没有引用指向，成为垃圾
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0, 0]
    }
}
