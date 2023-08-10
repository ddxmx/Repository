package com.test.basic.day01;

/**
 * 1、数据类型转换：
 * （1）自动类型转换：表示范围小的类型向表示范围大的类型进行自动转换。
 * （2）强制类型转换：不同表示范围类型的数据之间进行转换，可能会损失精度。
 * 2、自动类型转换规则：
 * 7种基本数值类型之间可以进行自动类型转换，不支持boolean类型和数值类型之间的转换。
 * byte、short、char < int < long < float < double
 * byte、short、char参与运算时，都会先转换成int类型，再进行计算
 */
public class TypeConversionDemo {
    public static void main(String[] args) {
        System.out.println("========自动类型转换========");
        {
            int i1 = 10;
            byte b1 = 20;
            // int类型 + byte类型 = int类型，byte类型自动转换成int类型
            int sum1 = i1 + b1;
            System.out.println(sum1); // 30

            int i2 = 100;
            double d2 = 10.01;
            // int类型 + double类型 = double类型，int类型自动转换为double类型
            double sum2 = i2 + d2;
            System.out.println(sum2); // 110.01

            byte b3 = 10;
            short s3 = 20;
            // 编译错误，byte、short、char进行运算时，计算结果很容易溢出，因此java先转换为int类型再计算
            // short sum3 = b3 + s3;
            // byte类型 + short类型 = int类型，byte类型和short类型自动转换为int类型
            int sum3 = b3 + s3;
            System.out.println(sum3); // 30
            // 直接进行转换，byte类型可以转换为short类型
            s3 = b3;
            System.out.println(s3); // 10

            int i4 = 10;
            char c4 = 'a';
            // int类型 + char类型 = int类型，char类型自动转换为int类型
            // char类型运算时会转换为int类型，char类型转换为表示的字符编码值，'a'编码为97
            int sum4 = i4 + c4;
            System.out.println(sum4); // 107

            // 编译通过，常量计算结果在byte范围内可以直接赋值，等价于byte sum5 = 30;
            byte sum5 = 10 + 20;
            // 编译错误，常量计算结果已经超过byte的范围-128~127
            // byte sum6 = 10 + 118;

            // final修饰的变量为常量
            final byte b7 = 10;
            final byte b8 = 20;
            // b7和b8都是常量，计算结果在byte范围内，等价于byte sum8 = 10 + 20
            byte sum8 = b7 + b8;
            System.out.println(sum8); // 30
        }

        System.out.println("========强制类型转换========");
        {
            int max = Integer.MAX_VALUE; // int类型的最大值
            int min = Integer.MIN_VALUE; // int类型的最小值
            System.out.println("int类型最大值：" + max); // int类型最大值：2147483647
            System.out.println("int类型最小值：" + min); // int类型最小值：-2147483648
            System.out.println("--------数据溢出--------");
            // 出现数据溢出，int类型 + int类型 = int类型
            System.out.println("最大值 + 1 = " + (max + 1)); // 最大值 + 1 = 最小值，-2147483648
            System.out.println("最大值 + 2 = " + (max + 2)); // 最大值 + 2 = 次小值，-2147483647
            System.out.println("最小值 - 1 = " + (min - 1)); // 最小值 - 1 = 最大值，2147483647
            System.out.println("--------数据溢出解决--------");
            // 数据溢出解决方法：扩大数据类型
            System.out.println("最大值 + 1 = " + ((long) max + 1)); // 最大值 + 1 = 2147483648
            System.out.println("最大值 + 2 = " + (max + 2L)); // 最大值 + 2 = 2147483649
            System.out.println("最小值 - 1 = " + (min - (long) 1)); // 最小值 - 1 = -2147483649

            // 强制类型转换可能会损失精度，double类型强制转换为int类型，直接舍弃小数位
            double d1 = 10.8;
            int i1 = (int) d1;
            System.out.println(i1); // 10
        }
    }
}