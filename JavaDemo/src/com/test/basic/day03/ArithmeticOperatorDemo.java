package com.test.basic.day03;

/**
 * 算术运算符(+、-、*、/、%)
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

        // 取模，就是取余数
        System.out.println(13 % 5); // 3
        System.out.println(-13 % 5); // -3
        System.out.println(13 % -5); // 3
        System.out.println(-13 % -5); // -3

        // 前自增，先将a1自增1，再返回a1的值
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1=" + a1 + ",b1=" + b1); // a1=11,b1=11

        // 后自减，先返回a2的值，再将a2自减1
        int a2 = 10;
        int b2 = a2--;
        System.out.println("a2=" + a2 + ",b2=" + b2); // a2=9,b2=10

        // 打印三位数的各个位置上的数字
        int value = 573; // 5 * 100 + 7 * 10 + 3
        int bai = value / 100;
        int shi = value % 100 / 10;
        int ge = value % 10;
        System.out.println("百位数：" + bai); // 5
        System.out.println("十位数：" + shi); // 7
        System.out.println("个位数：" + ge); // 3
    }
}
