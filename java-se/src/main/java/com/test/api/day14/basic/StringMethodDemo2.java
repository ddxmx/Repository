package com.test.api.day14.basic;

import java.util.Arrays;

/**
 * String常用方法2
 */
public class StringMethodDemo2 {
    public static void main(String[] args) {
        String s1 = "helloworld";

        System.out.println("=========================判断字符串是否以指定字符序列开头或结尾=========================");
        // public boolean startsWith(String prefix)
        System.out.println(s1.startsWith("he")); // true
        System.out.println(s1.startsWith("He")); // false
        // public boolean startsWith(String prefix, int toffset)
        System.out.println(s1.startsWith("w", 5)); // true
        // public boolean endsWith(String suffix)
        System.out.println(s1.endsWith("ld")); // true

        System.out.println("=========================判断字符串是否包含指定字符序列=========================");
        // public boolean contains(CharSequence s)
        System.out.println(s1.contains("ll")); // true
        System.out.println(s1.contains("LL")); // false

        System.out.println("=========================在字符串中查找指定字符串的位置=========================");
        // public int indexOf(String str)
        System.out.println(s1.indexOf("ll")); // 2
        // 不存在时，返回-1
        System.out.println(s1.indexOf("z")); // -1
        System.out.println(s1.indexOf("l", 5)); // 8
        // public int lastIndexOf(String str)
        System.out.println(s1.lastIndexOf("o")); // 6
        // 从指定位置（包含）开始，向前找
        // public int lastIndexOf(String str, int fromIndex)
        System.out.println(s1.lastIndexOf("o", 5)); // 4

        System.out.println("=========================替换字符串中指定字符序列=========================");
        // 替换所有出现的字符串，不支持正则
        // public String replace(CharSequence target, CharSequence replacement)
        String s2 = s1.replace("l", "z");
        System.out.println(s2); // hezzoworzd
        System.out.println(s1); // helloworld
        // 支持正则
        // public String replaceFirst(String regex, String replacement)
        System.out.println(s1.replaceFirst("l", "z")); // hezloworld
        System.out.println("123abc123".replaceFirst("\\d+", "")); // abc123
        // 支持正则
        // public String replaceAll(String regex, String replacement)
        System.out.println("123abc123".replaceAll("\\d+", "")); // abc

        System.out.println("=========================判断字符串是否匹配正则=========================");
        // 正则匹配
        // public boolean matches(String regex)
        System.out.println("abc123abc".matches("[a-z]+.*")); // true
        System.out.println("123456789".matches("\\d{9}")); // true

        System.out.println("=========================截取子字符串=========================");
        // public String substring(int beginIndex)
        System.out.println("helloworld".substring(5)); // world
        // public String substring(int beginIndex, int endIndex)
        System.out.println("helloworld".substring(0, 5)); // hello

        System.out.println("=========================将字符串按照分隔符分割为数组=========================");
        String s3 = "hello;world;java";
        // public String[] split(String regex)
        String[] arr1 = s3.split(";");
        System.out.println(Arrays.toString(arr1)); // [hello, world, java]
        String s4 = "192.168.1.100";
        // 分割字符是正则中有特殊含义的字符时，需要转义
        // 包含12个字符 . $ | ( ) [ { ^ ? * + \
        String[] arr2 = s4.split("\\.");
        System.out.println(Arrays.toString(arr2)); // [192, 168, 1, 100]
        String s5 = "aaa-bbb_ccc-ddd";
        // 支持根据多个分隔符拆分，使用|
        String[] arr3 = s5.split("-|_");
        System.out.println(Arrays.toString(arr3)); // [aaa, bbb, ccc, ddd]
    }
}
