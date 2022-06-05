package com.test.api.day14;

import java.util.Arrays;

/**
 * String的常用方法
 */
public class StringMethodDemo {
    public static void main(String[] args) {
        String s1 = "helloWorld";
        // public int length()
        System.out.println(s1.length()); // 10

        // 索引从0开始
        // public char charAt(int index)
        System.out.println(s1.charAt(4)); // o

        // public boolean isEmpty()
        System.out.println(s1.isEmpty()); // false
        System.out.println("".isEmpty()); // true

        String s2 = "helloWorld";
        // public String toUpperCase()
        System.out.println(s2.toUpperCase()); // HELLOWORLD
        System.out.println(s2); // helloWorld
        // public String toLowerCase()
        System.out.println(s2.toLowerCase()); // helloworld

        String s3 = " hello world ";
        // public String trim()
        System.out.println("[" + s3.trim() + "]"); // [hello world]
        System.out.println("[" + s3 + "]"); // [ hello world ]

        String s4 = "HelloWorld";
        // public boolean equals(Object anObject)
        System.out.println(s1.equals(s4)); // false
        // public boolean equalsIgnoreCase(String anotherString)
        System.out.println(s1.equalsIgnoreCase(s4)); // true

        // 字符串连接，等同于+
        // public String concat(String str)
        System.out.println("hello".concat("world")); // helloworld

        String[] array = new String[]{"aa", "bb", "cc"};
        // public static String join(CharSequence delimiter, CharSequence... elements)
        System.out.println(String.join("-", array)); // aa-bb-cc
        // public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
        System.out.println(String.join("-", Arrays.asList("11", "22", "33"))); // 11-22-33

        // 字符串排序，后续集合或数组排序依赖此方法，如TreeSet<String>、Arrays.sort()
        // public int compareTo(String anotherString)
        System.out.println("helloworld".compareTo("abc")); // 7
        System.out.println("helloWorld".compareTo("helloworld")); // -32
        System.out.println("helloWorld".compareTo("helloWorld")); // 0

        // 字符串格式化，变量可以都使用%s占位
        // public static String format(String format, Object... args)
        String s5 = String.format("姓名：%s，年龄：%d，成绩：%.2f", "张三", 18, 98.7654321);
        System.out.println(s5); // 姓名：张三，年龄：18，成绩：98.77
    }
}
