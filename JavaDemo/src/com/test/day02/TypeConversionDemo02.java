package com.test.day02;

/**
 * 强制类型转换，可能会损失精度
 * byte、short、char < int < long < float < double
 */
public class TypeConversionDemo02 {
    public static void main(String[] args) {
        double d1 = 10.8;
        int i1 = (int) d1;
        System.out.println(i1); // 10

        /*
        通过Integer.toBinaryString(128)可以获取128的二进制
        int类型的128的二进制为 1000_0000
        转换为byte类型后，高位为符号位，-0表示-128，+0表示0
         */
        int i2 = 128;
        System.out.println(Integer.toBinaryString(i2)); // 10000000
        byte b2 = (byte) i2;
        System.out.println(b2); // -128

        long num3 = 30_0000_0000L; //整数常量超过默认类型int表示范围，使用long类型表示
        float f4 = 1.21F; //小数常量默认类型为double类型，表示float类型时使用F后缀
    }
}
