package com.test.basic.day04.basic;

import java.util.Arrays;

/**
 * 数组是引用数据类型，是一组相同类型的数据集合
 * 内存中一块连续的区域，使用头指针查找。引用数据类型之所以用堆和栈两块内存空间，主要是因为只使用一块空间可能导致修改变量时空间不足
 * 数组的长度不可改变，因为数组要求地址是连续的
 * 数组中的元素可以是基本数据类型，也可以是引用数据类型
 */
public class OneDimArrayDemo {
    public static void main(String[] args) {
        // 静态初始化方式一（推荐方式），作为方法参数传递时，常量实参必须使用方式一的完整写法
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        // 静态初始化方式二（类型推断）
        String[] arr2 = {"hello", "world", "java"};

        // 动态初始化，元素的初始值为元素数据类型的默认值
        int[] arr3 = new int[3];
        System.out.println(arr3[0]); // 0
        System.out.println(arr3[1]); // 0
        System.out.println(arr3[2]); // 0
        // 元素的索引位置： 0 ~ 数组长度-1
        arr3[0] = 10;
        arr3[1] = 20;
        arr3[2] = 30;
        // 编译通过，运行报错，索引越界 ArrayIndexOutOfBoundsException
        // arr3[3] = 40;

        // 数组长度
        System.out.println(arr3.length); // 3

        // 遍历数组元素
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " "); // 10 20 30
        }
        System.out.println();

        int[] arr4 = new int[]{1, 2, 3};
        // 修改堆内存空间的值
        arr4[1] = 20;
        System.out.println(Arrays.toString(arr4)); // [1, 20, 3]
        // 更改指向的堆内存空间，原堆内存空间没有被栈内存空间指向，成为垃圾，等待GC回收
        arr4 = new int[5];
        System.out.println(Arrays.toString(arr4)); // [0, 0, 0, 0, 0]
    }
}
