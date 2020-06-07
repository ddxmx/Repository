package com.test.day02;

/**
 * 自动类型转换：表示范围小的类型向表示范围大的类型进行转换。
 * byte、short、char < int < long < float < double
 */
public class TypeConversionDemo03 {
    public static void main(String[] args) {
        int i1 = 10;
        byte b1 = 20;
        // int = int + byte
        int sum1 = i1 + b1; //30
        System.out.println(sum1);

        int i2 = 100;
        double d2 = 10.01;
        double sum2 = i2 + d2;
        System.out.println(sum2);

        byte b3 = 10;
        short s3 = 20;
        //编译失败，byte、short、char进行运算时，首先会转换为int类型再计算
//        short sum3 = b3 + s3;  //正确的应该是：int sum3 = b3 + s3;

        int i4 = 10;
        char c4 = 'a';
        int sum4 = i4 + c4;
        System.out.println(sum4); // 107，char类型会转换为int类型计算，根据表示编码进行转换，a编码为97

        byte b5 = 10;
        byte b6 = 20;
        //编译通过，计算结果在byte范围内，直接赋值
        byte sum5 = 10 + 20;
        //编译失败，结果已经超过byte的范围
//        byte sum5_2 = 10 + 118;
        //编译失败，b5和b6都是变量，无法保证结果是否属于byte范围内
//        byte sum6 = b5 + b6;

    }
}
