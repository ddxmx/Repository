package com.test.basic.day02;

/**
 * 自动类型转换：表示范围小的类型向表示范围大的类型进行自动转换。
 * 强制类型转换：不同表示范围类型的数据之间进行转换，可能会损失精度。
 * 7种基本数据类型之间可以进行自动类型转换，不支持boolean类型和数值类型之间的转换。
 * byte、short、char < int < long < float < double
 */
public class DataTypeConversionDemo {
    public static void main(String[] args) {
        // 自动类型转换
        {
            int i1 = 10;
            byte b1 = 20;
            // int类型 = int类型 + byte类型
            int sum1 = i1 + b1;
            System.out.println(sum1); // 30

            int i2 = 100;
            double d2 = 10.01;
            // double类型 = int类型 + double类型
            double sum2 = i2 + d2;
            System.out.println(sum2); // 110.01

            byte b3 = 10;
            short s3 = 20;
            // 编译失败，byte、short、char进行运算时，很容易计算结果溢出，因此java先转换为int类型再计算
            // short sum3 = b3 + s3;
            int sum3 = b3 + s3;
            System.out.println(sum3); // 30

            int i4 = 10;
            char c4 = 'a';
            // char类型会转换为int类型计算，char类型转换为表示的Unicode编码值，a编码为97
            int sum4 = i4 + c4;
            System.out.println(sum4); // 107

            // 编译通过，常量计算结果在byte范围内，等价于byte sum5 = 30;
            byte sum5 = 10 + 20;
            // 编译失败，常量计算结果已经超过byte的范围-128~127
            // byte sum6 = 10 + 118;
            byte b5 = 10;
            byte b6 = 20;
            // 编译失败，b5和b6都是变量，无法保证计算结果在byte范围内，需要使用int类型接收
            // byte sum7 = b5 + b6;
            int sum7 = b5 + b6;
            System.out.println(sum7); // 30

            final byte b7 = 10;
            final byte b8 = 20;
            // b7和b8都是常量，计算结果在byte范围内，等价于byte sum8 = 10 + 20
            byte sum8 = b7 + b8;
            System.out.println(sum8); // 30
        }

        // 强制类型转换
        {
            double d1 = 10.8;
            // double类型强制转换为int类型，直接舍弃小数位
            int i1 = (int) d1;
            System.out.println(i1); // 10

        /*
            通过Integer.toBinaryString(128)可以获取128的二进制补码形式
            int类型128的二进制为 1000_0000
            转换为byte类型后，高位为符号位，-0表示-128，+0表示0
            八位二进制-128只存在补码形式，不存在原码和反码形式
            -128 = -127 -1
            -127原码：1111 1111
            -127补码：1000 0001
            -128补码：1000 0000
        */
            int i2 = 128;
            // 获取i2的二进制补码形式
            System.out.println(Integer.toBinaryString(i2)); // 10000000
            byte b2 = (byte) i2;
            System.out.println(b2); // -128
        }
    }
}