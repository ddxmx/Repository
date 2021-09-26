package com.test.oop.day09;

/**
 * 参数的值传递机制
 * |-基本数据类型，传递的是数据的拷贝
 * |-引用数据类型，传递的是内存地址的拷贝
 */
public class ArgsBasicValueTransferDemo {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m=" + m + ",n=" + n); // m=10,n=20

        // 基本数据类型值交换
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10

        // 调用方法时，把m和n存储的值拷贝赋值给方法的参数，方法交换后，只交换了方法形参的值
        swap(m, n);
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10
    }

    /**
     * 数据交换
     *
     * @param x
     * @param y
     */
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
