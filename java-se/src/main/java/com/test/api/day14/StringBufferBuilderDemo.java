package com.test.api.day14;

/**
 * String、StringBuffer和StringBuilder异同
 * |- String：不可变的字符序列
 * |- StringBuffer：可变的字符序列，线程安全的，效率低
 * |- StringBuilder：JDK5.0新增，可变的字符序列，线程不安全的，效率高
 * |- 效率：StringBuilder > StringBuffer > String
 */
public class StringBufferBuilderDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length()); // 0

        // public synchronized StringBuffer append(int i)
        sb.append("abc").append(1).append('1');
        System.out.println(sb); // abc11

        // public synchronized StringBuffer delete(int start, int end)
        sb.delete(1, 3);
        System.out.println(sb); // a11

        // public synchronized StringBuffer insert(int offset, String str)
        sb.insert(0, "11");
        System.out.println(sb); // 11a11

        // public synchronized StringBuffer replace(int start, int end, String str)
        sb.replace(3, 5, "bb");
        System.out.println(sb); // 11abb

        // public synchronized StringBuffer reverse()
        System.out.println(sb.reverse()); // bba11
        System.out.println(sb); // bba11

        // public int indexOf(String str)
        System.out.println(sb.indexOf("11")); // 3

        // public synchronized String substring(int start, int end)
        System.out.println(sb.substring(0, 3)); // bba
        System.out.println(sb); // bba11

        // public synchronized char charAt(int index)
        System.out.println(sb.charAt(2)); // a

        // public synchronized void setCharAt(int index, char ch)
        sb.setCharAt(2, 'z');
        System.out.println(sb); // bbz11
    }
}
