package com.test.day03;

/**
 * 赋值运算符
 */
public class AssignOperDemo {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = i1;
        System.out.println(i2); //10

        int i3, i4;
        i3 = i4 = 20; //支持连续赋值
        System.out.printf("i3=%s,i4=%s\n", i3, i4); //i3=20,i4=20
        System.out.println(i3 = i4 = 30); //30，结果为赋值运算最右边的值

        short s1 = 10;
        s1 += 1; //等价于  s1 = (short)(s1 +1)
        System.out.println(s1); //11

        //实现+1的方式
        int i5 = 5;
        i5++; // 方式一
        i5 = i5 + 1; //方式二
        i5 += 1; //方式三

        int value = 10;
        value += (value++) + (++value); // 10 += 10 + 12
        System.out.println(value); //32
    }
}
