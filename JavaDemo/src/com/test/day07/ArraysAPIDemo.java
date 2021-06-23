package com.test.day07;

import java.util.Arrays;

/**
 * Arrays数组工具类使用
 */
public class ArraysAPIDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};
        int[] c = new int[]{1, 3, 2};

        //public static boolean equals(int[] a, int[] a2)
        System.out.println(Arrays.equals(a, b)); // true
        System.out.println(Arrays.equals(a, c)); // false

        //public static String toString(int[] a)
        System.out.println(Arrays.toString(a)); // [1, 2, 3]
        System.out.println(a.toString()); //[I@677327b6

        //public static void fill(int[] a, int val)
        Arrays.fill(c, 10);
        System.out.println(Arrays.toString(c)); // [10, 10, 10]

        // public static void sort(int[] a)
        int[] arr = new int[]{11, 23, 7, 9, 42, 65, 34, 96, 68};
        //sort方法直接修改源数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [7, 9, 11, 23, 34, 42, 65, 68, 96]

        //public static int binarySearch(int[] a, int key)
        //二分查找前提：数组已经排序
        System.out.println(Arrays.binarySearch(arr, 34)); // 4
        //元素没有查找到返回 -(插入位置+1)
        System.out.println(Arrays.binarySearch(arr, 55)); // -7
    }
}
