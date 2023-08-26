package com.test.api.day14.basic;

import java.util.Arrays;

/**
 * String的常用方法
 */
public class StringMethodDemo {
    public static void main(String[] args) {
        String s1 = "helloWorld";

        System.out.println("=========================获取字符串长度=========================");
        // public int length()
        System.out.println(s1.length()); // 10

        System.out.println("=========================获取索引位置字符=========================");
        // 索引从0开始
        // public char charAt(int index)
        System.out.println(s1.charAt(4)); // o

        System.out.println("=========================判断字符串是否为空=========================");
        // public boolean isEmpty()
        System.out.println(s1.isEmpty()); // false
        System.out.println("".isEmpty()); // true

        System.out.println("=========================字符串大小写转换=========================");
        String s2 = "helloWorld";
        // public String toUpperCase()
        System.out.println(s2.toUpperCase()); // HELLOWORLD
        System.out.println(s2); // helloWorld
        // public String toLowerCase()
        System.out.println(s2.toLowerCase()); // helloworld

        System.out.println("=========================去除字符串两端控制符=========================");
        String s3 = " hello world ";
        // public String trim()
        System.out.println("[" + s3.trim() + "]"); // [hello world]
        System.out.println("[" + s3 + "]"); // [ hello world ]

        System.out.println("=========================判断两个字符串是否相等=========================");
        String s4 = "HelloWorld";
        // public boolean equals(Object anObject)
        System.out.println(s1.equals(s4)); // false
        // public boolean equalsIgnoreCase(String anotherString)
        System.out.println(s1.equalsIgnoreCase(s4)); // true

        System.out.println("=========================字符串连接=========================");
        // 字符串连接，等同于+
        // public String concat(String str)
        System.out.println("hello".concat("world")); // helloworld

        System.out.println("=========================使用分隔符连接数组或集合的元素=========================");
        String[] array = new String[]{"aa", "bb", "cc"};
        // public static String join(CharSequence delimiter, CharSequence... elements)
        System.out.println(String.join("-", array)); // aa-bb-cc
        // public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
        System.out.println(String.join("-", Arrays.asList("11", "22", "33"))); // 11-22-33

        System.out.println("=========================两个字符串比较大小=========================");
        // 字符串排序，后续集合或数组排序依赖此方法，如TreeSet<String>、Arrays.sort()
        // public int compareTo(String anotherString)
        System.out.println("helloworld".compareTo("abc")); // 7
        System.out.println("helloWorld".compareTo("helloworld")); // -32
        System.out.println("helloWorld".compareTo("helloWorld")); // 0

        System.out.println("=========================字符串格式化=========================");
        // 字符串格式化，变量可以都使用%s占位
        // public static String format(String format, Object... args)
        String s5 = String.format("姓名：%s，年龄：%d，成绩：%.2f", "张三", 18, 98.7654321);
        System.out.println(s5); // 姓名：张三，年龄：18，成绩：98.77
    }
}
