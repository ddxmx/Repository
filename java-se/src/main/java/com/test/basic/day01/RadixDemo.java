package com.test.basic.day01;

/**
 * 常见的进制表示形式有四种：二进制、八进制、十进制和十六进制
 * 二进制 0b开头，八进制 0开头，十六进制 0x开头
 * 计算机底层都是使用补码形式存储数据
 * 计算机底层进行减法运算时，实际上也是用的加法，1 - 1 = 1 + (-1)
 * 为什么计算机底层都是使用补码方式进行计算？
 * |- 使用原码的方式 1-1=1+(-1)=0000_0001 + 1000_0001 = 1000_0010，不用原码表示是因为原码计算结果不正确
 * |- 使用补码的方式 1-1=1+(-1)=0000_0001 + 1111_1111 = 0000_0000 = 0
 */
public class RadixDemo {
    public static void main(String[] args) {
        System.out.println("========进制表示========");
        int i1 = 0b1100; // 二进制
        int i2 = 011; // 八进制
        int i3 = 100; // 十进制
        int i4 = 0x1a; // 十六进制
        System.out.println(i1); // 12
        System.out.println(i2); // 9
        System.out.println(i3); // 100
        System.out.println(i4); // 26

        /*
            计算机中所有数都是以补码形式存在
            正数的原码、反码、补码都一致
            负数的原码 = 符号位为1，其余位和对应的正数一致
            负数的反码 = 负数的原码除符号位外，按位取反
            负数的补码 = 负数的反码 + 1
            -128在8位二进制下不存在原码和反码，只存在补码
            0 1 1 1  1 1 1 1  127原码
            1 1 1 1  1 1 1 1  -127原码
            1 0 0 0  0 0 0 0  -127反码
            1 0 0 0  0 0 0 1  -127补码
            1 0 0 0  0 0 0 0  -128补码（-127-1）
         */

        System.out.println("========十进制转换为其他进制========");
        // 十进制转换其他进制表示形式，使用Integer类中的toString()方法
        int num = -12;
        // 十进制转换为二进制
        String value = Integer.toString(num, 2);
        System.out.println(value); // -1100
        // 十进制转换为八进制
        String value2 = Integer.toString(num, 8);
        System.out.println(value2); // -14
        // 十进制转换为十六进制
        String value3 = Integer.toString(num, 16);
        System.out.println(value3); // -c

        System.out.println("========其他进制转换为十进制========");
        // 其他进制转换为十进制表示形式，使用Integer类中的parseInt()方法
        int num2 = Integer.parseInt(value, 2);
        System.out.println(num2); // -12
        int num3 = Integer.parseInt(value2, 8);
        System.out.println(num3); // -12
        int num4 = Integer.parseInt(value3, 16);
        System.out.println(num4); // -12

        System.out.println("========十进制转换为其他进制补码形式========");
        // 十进制转换为其他进制补码形式，使用Integer类中的toBinaryString()、toOctalString()、toHexString()方法
        /*
            10000000 00000000 00000000 00001100 -12原码
            11111111 11111111 11111111 11110011 -12反码
            11111111 11111111 11111111 11110100 -12补码
            二进制和八进制、十六进制转换：
            |- 二进制转八进制、十六进制：补码三位变一位、四位变一位
            |- 八进制、十六进制转二进制：补码一位变三位、一位变四位
         */
        System.out.println(Integer.toBinaryString(num)); // 11111111111111111111111111110100
        // 三位变一位，11_111_111_111_111_111_111_111_111_110_100
        System.out.println(Integer.toOctalString(num)); // 37777777764
        // 四位变一位，1111_1111_1111_1111_1111_1111_1111_0100
        System.out.println(Integer.toHexString(num)); // fffffff4
    }
}
