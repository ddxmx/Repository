package com.test.api.day14;

/**
 * String、StringBuffer和StringBuilder异同
 * 1、String：不可变的字符序列
 * 2、StringBuffer：可变的字符序列，线程安全的，效率低
 * 3、StringBuilder：JDK5.0新增，可变的字符序列，线程不安全的，效率高
 * 效率：StringBuilder > StringBuffer > String
 */
public class StringBufferBuilderDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length()); // 0

        sb.append("abc").append(1).append('1');
        System.out.println(sb); // abc11

        sb.delete(1, 3);
        System.out.println(sb); // a11

        sb.insert(0, "11");
        System.out.println(sb); // 11a11

        sb.replace(3, 5, "bb");
        System.out.println(sb); // 11abb

        System.out.println(sb.reverse()); // bba11
        System.out.println(sb); // bba11

        System.out.println(sb.indexOf("11")); // 3

        System.out.println(sb.substring(0, 3)); // bba
        System.out.println(sb); // bba11

        System.out.println(sb.charAt(2)); // a

        sb.setCharAt(2, 'z');
        System.out.println(sb); // bbz11
    }
}
