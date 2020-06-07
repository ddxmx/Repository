package com.test.day07;

import java.util.Arrays;

/**
 * Arrays类使用
 */
public class ArraysDemo06 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 2, 3};
        int[] c = new int[]{1, 3, 2};
        //public static boolean equals(int[] a, int[] a2)
        System.out.println(Arrays.equals(a, b)); // true
        System.out.println(Arrays.equals(a, c)); // true

        //public static String toString(int[] a)
        System.out.println(Arrays.toString(a)); // [1, 2, 3]

        //public static void fill(int[] a, int val)
        Arrays.fill(c, 10);
        System.out.println(Arrays.toString(c)); // [10, 10, 10]

        // public static void sort(int[] a)
        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        //public static int binarySearch(int[] a, int key)
        System.out.println(Arrays.binarySearch(arr, 4)); // 3
    }
}
