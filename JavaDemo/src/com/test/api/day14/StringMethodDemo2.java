package com.test.api.day14;

import java.util.Arrays;

/**
 * String常用方法2
 */
public class StringMethodDemo2 {
    public static void main(String[] args) {
        String s1 = "helloworld";
        System.out.println(s1.startsWith("he")); // true
        System.out.println(s1.startsWith("He")); // false
        System.out.println(s1.startsWith("w", 5)); // true
        System.out.println(s1.endsWith("ld")); // true

        System.out.println(s1.contains("ll")); // true

        System.out.println(s1.indexOf("ll")); // 2
        // 不存在时，返回-1
        System.out.println(s1.indexOf("z")); // -1
        System.out.println(s1.indexOf("l", 5)); // 8
        System.out.println(s1.lastIndexOf("o")); // 6
        // 从指定位置（包含）开始，向前找
        System.out.println(s1.lastIndexOf("o", 5)); // 4

        System.out.println("*************************************");
        // 替换所有出现的字符串，不支持正则
        String s2 = s1.replace("l", "z");
        System.out.println(s2); // hezzoworzd
        System.out.println(s1); // helloworld
        // 支持正则
        System.out.println(s1.replaceFirst("l", "z")); // hezloworld
        System.out.println("123abc123".replaceFirst("\\d+", "")); // abc123
        // 支持正则
        System.out.println("123abc123".replaceAll("\\d+", "")); // abc

        System.out.println("abc123abc".matches("[a-z]+.*")); // true
        System.out.println("123456789".matches("\\d{9}")); // true

        System.out.println("helloworld".substring(5)); // world
        System.out.println("helloworld".substring(0, 5)); // hello

        String s3 = "hello;world;java";
        String[] arr1 = s3.split(";");
        System.out.println(Arrays.toString(arr1)); // [hello, world, java]

        String s4 = "192.168.1.100";
        // 分割字符是正则中有特殊含义的字符时，需要转义
        String[] arr2 = s4.split("\\.");
        System.out.println(Arrays.toString(arr2)); // [192, 168, 1, 100]
    }
}
