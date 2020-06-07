package com.test.day09;

class Demo06 {
    int a = 10;
    int b = 20;
}

public class SwapDemo06 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        // 调用方法无法完成基本数据类型变量值的交换
        swap(num1, num2);
        System.out.println("num1=" + num1 + ",num2=" + num2); // num1=10,num2=20

        Demo06 demo = new Demo06();
        System.out.println("demo.a=" + demo.a + ",demo.b=" + demo.b); // demo.a=10,demo.b=20
        swap(demo);
        System.out.println("demo.a=" + demo.a + ",demo.b=" + demo.b); // demo.a=20,demo.b=10
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * 操作的是同一个堆内存地址，交换对象属性值后，结果被保存
     *
     * @param demo
     */
    public static void swap(Demo06 demo) {
        int temp = demo.a;
        demo.a = demo.b;
        demo.b = temp;
    }
}
