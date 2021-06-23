package com.test.day09;

/**
 * 引用数据类型的参数值传递
 */
public class ArgsValueTransferDemo2 {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("m=" + data.m + ",n=" + data.n); //m=10,n=20

        int temp = data.m;
        data.m = data.n;
        data.n = temp;
        System.out.println("m=" + data.m + ",n=" + data.n); //m=20,n=10

        ArgsValueTransferDemo2 demo = new ArgsValueTransferDemo2();
        //实参和形参2个data都指向同一块堆内存空间，对堆内存空间的操作结果被保留下来
        demo.swap(data);
        System.out.println("m=" + data.m + ",n=" + data.n); //m=10,n=20
    }

    public void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data {
    int m = 10;
    int n = 20;
}
