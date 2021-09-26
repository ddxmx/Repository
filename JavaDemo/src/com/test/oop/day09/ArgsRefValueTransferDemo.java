package com.test.oop.day09;

/**
 * 引用数据类型的参数值传递
 */
public class ArgsRefValueTransferDemo {
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
    }

    public static void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data {
    int m = 10;
    int n = 20;
}
