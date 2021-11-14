package com.test.basic.day02;

/**
 * 赋值运算符
 * 在二元运算符中，赋值运算符优先级最低
 * 对于基本数据类型来说，赋值操作实际是拷贝了一份变量保存的值后再进行赋值操作
 */
public class AssignOperatorDemo {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = i1;
        System.out.println(i2); // 10
        i1 = 15;
        System.out.println("i1=" + i1 + ",i2=" + i2); // i1=15,i2=10

        int i3, i4;
        i3 = i4 = 20; // 支持连续赋值
        System.out.println("i3=" + i3 + ",i4=" + i4); // i3=20,i4=20
        System.out.println(i3 = i4 = 30); // 30，结果为赋值运算符最右边的值
        System.out.println("i3=" + i3 + ",i4=" + i4); // i3=30,i4=30

        short s1 = 10;
        s1 += 1; // 等价于 s1 = (short)(s1 +1)
        System.out.println(s1); // 11

        // 实现+1效果的不同方式
        int i5 = 5;
        i5++; // 方式一
        i5 = i5 + 1; // 方式二
        i5 += 1; // 方式三

        int value = 10;
        value += (value++) + (++value); // value = value + (value++) + (++value) = 10 + 10 + 12
        System.out.println(value); // 32
    }
}
