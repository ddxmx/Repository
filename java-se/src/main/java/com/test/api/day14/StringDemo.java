package com.test.api.day14;

/**
 * String类的使用
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "hello"; // 字面量直接入池
        String str2 = "hello"; // 直接使用常量池中的对象
        System.out.println(str1 == str2); // true

        String str3 = str2;
        // 字符串的值一旦创建不可修改，只是修改了引用指向的堆内存地址
        str3 += " world";
        System.out.println(str3); // hello world
        System.out.println(str2); // hello

        // 空字符串
        System.out.println("".equals(new String())); // true

        // 在堆空间中开辟新空间
        // 在内存中创建了2个对象，一个是堆空间中new出来的hello对象，另一个是常量池中的hello对象。
        String str4 = new String(str1);
        System.out.println(str4 == str1); // false

        System.out.println("================字符串比较================");
        String s1 = "hello"; // 存储在常量池
        String s2 = "world"; // 存储在常量池
        String s3 = "helloworld"; // 存储在常量池
        String s4 = "hello" + "world"; // 连接后存储在常量池
        String s5 = s1 + "world"; // 堆
        String s6 = s1 + s2; // 堆
        // intern()方法将对象保存在常量池中，并返回常量池的引用
        String s7 = s6.intern(); // 存储在常量池
        // final值在编译期就可以确定，保存在常量池中
        final String s8 = "hello";
        String s9 = s8 + "world"; // 连接后存储在常量池

        // 字符串使用常量拼接，结果保存在常量池中；使用变量进行连接时，不会使用常量池，直接在堆内存中开辟空间
        // 都在常量池中保存
        System.out.println(s3 == s4); // true
        // s5使用变量拼接，保存在堆内存
        System.out.println(s3 == s5); // false
        // s6使用变量拼接，保存在堆内存
        System.out.println(s3 == s6); // false
        // s5和s6开辟的不同的堆内存
        System.out.println(s5 == s6); // false
        // intern()方法将字符串放入常量池中再引用，常量池中已经存在，直接返回常量池中对象
        System.out.println(s3 == s7); // true
        // 常量拼接，在常量池中保存
        System.out.println(s3 == s9); // true
    }
}
