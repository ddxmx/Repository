package com.test.oop.day06;

class Data {
    int m = 10;
    int n = 20;
}

/**
 * 引用数据类型的值传递
 */
public class RefValueTransferDemo {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("m=" + data.m + ",n=" + data.n); // m=10,n=20

        // 引用数据类型中属性值交换
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
        System.out.println("m=" + data.m + ",n=" + data.n); // m=20,n=10

        // 实参和形参2个data对象都指向同一块堆内存空间，对堆内存空间的操作结果被保留下来
        swap(data);
        System.out.println("m=" + data.m + ",n=" + data.n); // m=10,n=20

        // 传递的是数据的拷贝，只会影响方法内参数的结果
        swap(data.m, data.n);
        System.out.println("m=" + data.m + ",n=" + data.n); // m=10,n=20
    }

    public static void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }

    public static void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
}
