package com.test.basic.day02;

/**
 * 算术运算符(+、-、*、/、%、++、--)
 * 一元运算符优先级高于二元运算符
 * 在二元运算符中，算术运算符优先级最高
 */
public class ArithmeticOperatorDemo {
    public static void main(String[] args) {
        // 除法
        // int类型 / int类型 = int类型，小数位直接舍弃
        System.out.println(14 / 4); // 3
        System.out.println(14 / 4 * 4); // 12
        // double类型 / int类型 = double类型
        System.out.println((double) 14 / 4); // 3.5

        // 除法运算中，除数为0将抛出java.lang.ArithmeticException异常
        // int value = 10 / 0;

        // 取模，就是求余数
        System.out.println(13 % 5); // 3，商为2
        System.out.println(-13 % 5); // -3，商为-2
        System.out.println(13 % -5); // 3，商为-2
        System.out.println(-13 % -5); // -3，商为2

        // 前自增，先将a1自增1，再返回a1的值
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1=" + a1 + ",b1=" + b1); // a1=11,b1=11

        // 后自减，先返回a2的值，再将a2自减1
        int a2 = 10;
        int b2 = a2--;
        System.out.println("a2=" + a2 + ",b2=" + b2); // a2=9,b2=10
    }
}
