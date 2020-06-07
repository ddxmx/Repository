package com.test.day09;

/**
 * 面试题
 */
public class OfferDemo07 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        // 调用的方法 public void println(Object x)
        System.out.println(arr1); // [I@1540e19d

        char[] arr2 = new char[]{'a', 'b', 'c'};
        // 调用的方法 public void println(char x[])
        System.out.println(arr2); // abc
    }
}
