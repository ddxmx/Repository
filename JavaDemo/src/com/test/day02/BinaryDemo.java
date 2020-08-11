package com.test.day02;

/**
 * 二进制 0b开头
 * 八进制 0开头
 * 十六进制 0x开头
 */
public class BinaryDemo {
    public static void main(String[] args) {
        int i1 = 0b1100; //二进制
        int i2 = 00011; //八进制
        int i3 = 100; //十进制
        int i4 = 0x001a; //十六进制
        System.out.println(i1); //12
        System.out.println(i2); //9
        System.out.println(i3); //100
        System.out.println(i4); //26

        /*
            计算机中所有数都是以补码形式存在
            正数的原码、反码、补码都一致
            负数的原码 = 符号位为1，其余位和对应的正数一致
            负数的反码 = 原码除符号位外，按位取反
            负数的补码 = 补码 + 1

            0 1 1 1  1 1 1 1  127原码
            1 1 1 1  1 1 1 1  -127原码
            1 0 0 0  0 0 0 0  -127反码
            1 0 0 0  0 0 0 1  -127补码
            1 0 0 0  0 0 0 0  -128补码
         */

        int num = 12;
        //10进制转换其他进制，方式一
        //Integer.toBinaryString(num); // 十进制转换为二进制，除以2倒叙取余数
        //Integer.toOctalString(num); // 十进制转换为八进制
        //Integer.toHexString(num); // 十进制转换为十六进制

        //10进制转换其他进制，方式二
        String value = Integer.toString(num, 2); //1100
        Integer.toString(num, 8);
        Integer.toString(num, 16);

        //二进制转换为十进制，按位乘以位权，累加
        int num2 = Integer.parseInt(value, 2);
        System.out.println(num2); // 12

        /*
             二进制和八进制、十六进制转换：
             二进制转八进制、十六进制：三位变一位、四位变一位
             八进制、十六进制转二进制：一位变三位、一位变四位
        */
    }
}
