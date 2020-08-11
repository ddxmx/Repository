package com.test.day03;

/**
 * 位运算符
 * << >> >>> & | ^ !
 * 位运算不会改变操作数的值
 */
public class BitOperDemo {
    public static void main(String[] args) {
        int a1 = 3;
        //左移操作等价于 * 2^n
        System.out.println(a1 << 2); //3*(2^2)=12
        System.out.println("a1=" + a1); //a1=3
        int a2 = -3;
        System.out.println(a2 << 2); //-12

        int a3 = 9;
        //右移操作，操作数为正数，/ 2^n
        System.out.println(a3 >> 2); //9/(2^2)=2

        /*
         = 10 00000000 00000000 00000000 001001（原码）
         = 11 11111111_11111111_11111111_110111（补码）
         >>2
         = 11111111_11111111_11111111_11111101 (>>2后补码)
         = 10000000_00000000_00000000_00000011 (>>2后原码)
        */
        int a4 = -9;
        //数字转换为二进制字符串
        System.out.println(Integer.toBinaryString(-9)); //11111111_11111111_11111111_11110111
        System.out.println(a4 >> 2); // -3


        int a5 = 9;
        //无符号右移操作，操作数为正数，/ 2^n
        System.out.println(a5 >>> 2); // 9/(2^2)=2
        int a6 = -9;
        System.out.println(a6 >>> 2); // 1073741821

        int num1 = 3; //0000 0011
        int num2 = 2; //0000 0010
        System.out.println(num1 & num2); //0000 0010 = 2
        System.out.println(num1 | num2); //0000 0011 = 3
        System.out.println(num1 ^ num2); //0000 0001 = 1
        //11111111_11111111_11111111_11111100(反码)=10000000_00000000_00000000_00000100(原码)=-4
        System.out.println(~num1); //-4

        int num3 = 10;
        System.out.println(3 ^ num3); //9
        System.out.println(3 ^ num3 ^ num3); //3，异或同一个数2次，等于本身
        System.out.println(~num3); //-11
        System.out.println(~(~num3)); //10，取反2次等于本身
    }
}
