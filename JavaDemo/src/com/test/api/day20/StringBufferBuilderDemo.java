package com.test.api.day20;

/**
 * String、StringBuffer和StringBuilder异同
 * 1、String：不可变的字符序列
 * 2、StringBuffer：可变的字符序列，线程安全的，效率低
 * 3、StringBuilder：JDK5.0新增，可变的字符序列，线程不安全的，效率高
 * 效率：StringBuilder > StringBuffer > String
 * <p>
 * String str = new String(); // char[] value = new char[0]
 * String str2 = new String("abc"); // char[] value = new char[3];
 * StringBuffer sb = new StringBuffer(); // char[] value = new char[16];
 * StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16]
 * <p>
 * StringBuffer扩容：
 * 默认扩容原数组长度 * 2 + 2,并将原数组元素复制到新数组
 * 建议开发中使用指定容量的构造器 public StringBuffer(int capacity)
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

        System.out.println(sb.indexOf("11")); // 3

        String substring = sb.substring(0, 3);
        System.out.println(substring); // bba
        System.out.println(sb); // bba11

        char c = sb.charAt(2);
        System.out.println(c); // a

        sb.setCharAt(2, 'z');
        System.out.println(sb); // bbz11
    }
}
