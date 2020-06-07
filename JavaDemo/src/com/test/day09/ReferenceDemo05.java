package com.test.day09;

class Demo05 {
    int value = 100;
}

public class ReferenceDemo05 {
    public static void main(String[] args) {
        int a = 10;
        int b = a; // 基本数据类型赋值是把值的副本赋值给其他变量
        a = 20;
        System.out.println("a=" + a + ",b=" + b); // a=20,b=10

        String str1 = "hello";
        String str2 = str1; // String类型赋值是传递堆内存地址
        str1 = "world"; // string类不可变，修改了str1指向的堆内存地址，str2仍指向原来的堆内存地址
        System.out.println("str1=" + str1 + ",str2=" + str2); // str1=world,str2=hello

        Demo05 demo1 = new Demo05();
        Demo05 demo2 = demo1; // 指向同一个堆内存地址
        demo1.value = 200; // 修改同一个堆内存地址中的值
        System.out.println("demo1.value=" + demo1.value + ",demo2.value=" + demo2.value); // demo1.value=200,demo2.value=200
    }
}
