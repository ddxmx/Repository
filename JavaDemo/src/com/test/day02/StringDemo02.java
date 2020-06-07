package com.test.day02;

/**
 * String属于引用数据类型
 */
public class StringDemo02 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "";
        String str3 = null;

        String str4 = "计算结果：" + 1 + 2;
        String str5 = "计算结果：" + (1 + 2);
        System.out.println(str4);
        System.out.println(str5);
    }
}
