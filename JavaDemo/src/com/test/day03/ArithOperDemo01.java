package com.test.day03;

public class ArithOperDemo01 {
    public static void main(String[] args) {
        int num1 = 14;
        int num2 = 4;

        //除法
        System.out.println(num1 / num2); //3
        System.out.println(num1 / num2 * num2); //12
        System.out.println((double) num1 / num2); //3.5
        System.out.println("******************************");

        //取模
        System.out.println(13 % 5);//3
        System.out.println(-13 % 5);//-3
        System.out.println(13 % -5);//3
        System.out.println(-13 % -5);//-3
        System.out.println("******************************");

        int a1 = 10;
        int b1 = ++a1;
        System.out.printf("a1=%s,b1=%s\n", a1, b1); //a1=11,b1=11
        System.out.println("******************************");

        int a2 = 10;
        int b2 = a2++;
        System.out.printf("a2=%s,b2=%s\n", a2, b2); //a2=11,b2=10
        System.out.println("******************************");

        short s1 = 10;
        s1 += 1; //等价于  s1 = (short)(s1 +1)
        System.out.println(s1); //11
        System.out.println("******************************");

        //打印每个位置的数字
        int num = 287;
        System.out.println(num / 100 % 10); //2
        System.out.println(num / 10 % 10);//8
        System.out.println(num % 10);//7
    }
}
