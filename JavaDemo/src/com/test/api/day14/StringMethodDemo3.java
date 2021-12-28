package com.test.api.day14;

import java.util.Arrays;

/**
 * String的常用方法3
 * String和char[]和byte[]的转换
 */
public class StringMethodDemo3 {
    public static void main(String[] args) throws Exception {
        // String和char[]转换
        {
            String s1 = "abc123";
            char[] arr1 = s1.toCharArray();
            System.out.println(Arrays.toString(arr1)); // [a, b, c, 1, 2, 3]

            char[] chars = new char[]{'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
            String s2 = new String(chars);
            System.out.println(s2); // helloworld
            String s3 = new String(chars, 5, 3);
            System.out.println(s3); // wor
        }

        // String和byte[]转换
        {
            /*
                乱码形成的原因主要包含两种：
                1、解析错误，UTF-8的编码使用GBK编码解析，这种错误不会改变原来二进制内容
                2、错误的解析和编码转换：UTF-8的编码，使用GBK解析后转换成ISO8859-1编码
             */
            String s1 = "abc123";
            byte[] bytes = s1.getBytes();
            // 英文和数字使用1个字节表示
            System.out.println(Arrays.toString(bytes)); // [97, 98, 99, 49, 50, 51]

            String s2 = "abc123中国";
            // UTF-8：3个字节表示一个中文
            byte[] bytes_utf8 = s2.getBytes();
            System.out.println(Arrays.toString(bytes_utf8)); // [97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]
            // GBK：2个字节表示一个中文
            byte[] bytes_gbk = s2.getBytes("GBK");
            System.out.println(Arrays.toString(bytes_gbk)); // [97, 98, 99, 49, 50, 51, -42, -48, -71, -6]

            String s3 = new String(bytes_utf8);
            System.out.println(s3); // abc123中国

            // 编码和解码使用的编码方式不同，造成乱码
            System.out.println(new String(bytes_gbk)); // abc123�й�
            System.out.println(new String(bytes_gbk, "GBK")); // abc123中国
        }
    }
}
