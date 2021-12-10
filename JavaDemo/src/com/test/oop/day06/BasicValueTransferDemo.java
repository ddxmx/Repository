package com.test.oop.day06;

/**
 * 参数的值传递机制
 * |-基本数据类型，传递的是数据的拷贝
 * |-引用数据类型，传递的是内存地址的拷贝
 */
public class BasicValueTransferDemo {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m=" + m + ",n=" + n); // m=10,n=20

        // 交换两个基本数据类型变量存储的值
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10

        // 调用方法时，把m和n存储的值拷贝赋值给方法的参数，方法执行后，只交换了方法形参的值
        swap(m, n);
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10
    }

    /**
     * 数据交换
     */
    public static void swap(int x, int y) {
        System.out.println("x=" + x + ",y=" + y); // x=20,y=10
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x=" + x + ",y=" + y); // x=10,y=20
    }
}
