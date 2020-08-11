package com.test.day02;

/**
 * String属于引用数据类型
 * 字符串连接使用符号 +
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "";
        String str3 = null;

        String str4 = "计算结果：" + 1 + 2;
        String str5 = "计算结果：" + (1 + 2);
        System.out.println(str4);
        System.out.println(str5);

        //String str6 = 123; //编译失败，不能进行直接转型
        String str7 = String.valueOf(123); //int -> String
    }
}
