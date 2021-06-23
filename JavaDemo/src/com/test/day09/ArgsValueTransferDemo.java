package com.test.day09;

/**
 * 方法参数的值传递机制
 * 形参：方法定义时的参数
 * 实参：方法调用时传递的参数
 * 基本数据类型，传递的是数据的拷贝
 * 引用数据类型，传递的是内存地址的拷贝
 */
public class ArgsValueTransferDemo {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m=" + m + ",n=" + n); //m=10,n=20

        int temp = m;
        m = n;
        n = temp;
        System.out.println("m=" + m + ",n=" + n); //m=20,n=10

        ArgsValueTransferDemo demo = new ArgsValueTransferDemo();
        //调用方法时，把m和n存储的值拷贝给方法的参数，方法交换后，只交换了方法参数的值
        demo.swap(m, n);
        System.out.println("m=" + m + ",n=" + n); //m=20,n=10
    }

    /**
     * 数据交换
     *
     * @param x
     * @param n
     */
    public void swap(int x, int n) {
        int temp = x;
        x = n;
        n = temp;
    }
}
