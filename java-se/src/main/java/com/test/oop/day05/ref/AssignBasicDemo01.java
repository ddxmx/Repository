package com.test.oop.day05.ref;

/**
 * 参数的值传递机制
 * |-基本数据类型，传递的是数据的拷贝
 * |-引用数据类型，传递的是内存地址的拷贝
 */
public class AssignBasicDemo01 {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m=" + m + ",n=" + n); // m=10,n=20

        // 交换两个基本数据类型变量存储的值，m和n重新被赋值
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10

        // 调用方法时，把m和n存储的值拷贝赋值给方法的形参，方法执行只交换了形参的值
        swap(m, n);
        System.out.println("m=" + m + ",n=" + n); // m=20,n=10
    }

    /**
     * 数据交换
     * 形参：形式参数，出现在方法定义中，形参只是用来占位的，用来代表未来调用时传递过来的数据
     * 实参：实际参数，出现在方法调用中，实参是方法执行时真正要用到的数据
     */
    public static void swap(int x, int y) {
        System.out.println("x=" + x + ",y=" + y); // x=20,y=10
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x=" + x + ",y=" + y); // x=10,y=20
    }
}
