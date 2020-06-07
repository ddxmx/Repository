package com.test.day03;

public class AssignOperDemo02 {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = i1;
        System.out.println(i2);//10

        int i3, i4;
        i3 = i4 = 20;
        System.out.printf("i3=%s,i4=%s\n", i3, i4);//i3=20,i4=20
        System.out.println(i3 = i4 = 30);//30，结果为赋值运算最右边的值

        int num = 10;
        num += 2;
        num = num + 2;

        int value = 10;
        value += (value++) + (++value); // 10 += 10 + 12
        System.out.println(value);//32
    }
}
