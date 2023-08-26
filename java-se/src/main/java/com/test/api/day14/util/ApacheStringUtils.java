package com.test.api.day14.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Apache的StringUtils类扩展了java.lang.String类的能力
 * 其他的方法和java.lang.String中命名几乎一致
 */
public class ApacheStringUtils {
    public static void main(String[] args) {
        System.out.println("=========================判断字符串是否为空=========================");
        // public static boolean isEmpty(CharSequence cs)
        System.out.println(StringUtils.isEmpty(null)); // true
        System.out.println(StringUtils.isEmpty("")); // true
        System.out.println(StringUtils.isEmpty(" ")); // false
        // public static boolean isNotEmpty(CharSequence cs)
        System.out.println(StringUtils.isNotEmpty(null)); // false
        System.out.println(StringUtils.isNotEmpty("")); // false
        System.out.println(StringUtils.isNotEmpty(" ")); // true

        System.out.println("=========================判断字符串是否为空白=========================");
        // public static boolean isBlank(CharSequence cs)  判断字符串是否为空或长度为0或由空白符(whitespace)构成
        System.out.println(StringUtils.isBlank(null)); // true
        System.out.println(StringUtils.isBlank("")); // true
        System.out.println(StringUtils.isBlank(" ")); // true
        System.out.println(StringUtils.isBlank("abc")); // false
        // public static boolean isNotBlank(CharSequence cs)  判断字符串是否为空或长度为0或由空白符(whitespace)构成
        System.out.println(StringUtils.isNotBlank(null)); // false
        System.out.println(StringUtils.isNotBlank("")); // false
        System.out.println(StringUtils.isNotBlank(" ")); // false
        System.out.println(StringUtils.isNotBlank("abc")); // true

        System.out.println("=========================判断字符串是否为空白符=========================");
        // public static boolean isWhitespace(CharSequence cs)
        System.out.println(StringUtils.isWhitespace(null)); // false
        System.out.println(StringUtils.isWhitespace("")); // true
        System.out.println(StringUtils.isWhitespace(" ")); // true
        System.out.println(StringUtils.isWhitespace("\r")); // true
        System.out.println(StringUtils.isWhitespace("\n\r")); // true
        System.out.println(StringUtils.isWhitespace("abc")); // false

        System.out.println("=========================除字符串两端控制符后转换=========================");
        // public static String trimToEmpty(String str)  去除字符串两端控制符后为null或""，则返回""
        System.out.println(StringUtils.trimToEmpty(null)); // ""
        System.out.println(StringUtils.trimToEmpty("")); // ""
        System.out.println(StringUtils.trimToEmpty(" ")); // ""
        System.out.println(StringUtils.trimToEmpty(" abc")); // abc
        // public static String trimToNull(String str)  去除字符串两端控制符后为null或""，则返回null
        System.out.println(StringUtils.trimToNull(null)); // null
        System.out.println(StringUtils.trimToNull("")); // null
        System.out.println(StringUtils.trimToNull(" ")); // null
        System.out.println(StringUtils.trimToNull("abc ")); // abc

        System.out.println("=========================判断字符串是否是数字和字母=========================");
        // public static boolean isNumeric(CharSequence cs)
        System.out.println(StringUtils.isNumeric(null)); // false
        System.out.println(StringUtils.isNumeric("中1")); // false
        System.out.println(StringUtils.isNumeric("abc")); // false
        System.out.println(StringUtils.isNumeric("123")); // true
        System.out.println(StringUtils.isNumeric("12'3")); // false
        System.out.println("-------------------------------------------------------------------------");
        // public static boolean isAlpha(CharSequence cs)
        System.out.println(StringUtils.isAlpha(null)); // false
        System.out.println(StringUtils.isAlpha("中a")); // true
        System.out.println(StringUtils.isAlpha("abc")); // true
        System.out.println(StringUtils.isAlpha("123")); // false
        System.out.println(StringUtils.isAlpha("ab'c")); // false
        System.out.println("-------------------------------------------------------------------------");
        // public static boolean isAlphanumeric(CharSequence cs)
        System.out.println(StringUtils.isAlphanumeric(null)); // false
        System.out.println(StringUtils.isAlphanumeric("中")); // true
        System.out.println(StringUtils.isAlphanumeric("abc")); // true
        System.out.println(StringUtils.isAlphanumeric("123")); // true
        System.out.println(StringUtils.isAlphanumeric("a2'3")); // false

        System.out.println("=========================字符串首字母大写=========================");
        // public static String capitalize(String str)
        System.out.println(StringUtils.capitalize(null)); // null
        System.out.println(StringUtils.capitalize("hello")); // Hello
        System.out.println(StringUtils.capitalize("HELLO")); // HELLO

        System.out.println("=========================字符串反转=========================");
        // public static String reverse(String str)
        System.out.println(StringUtils.reverse(null)); // null
        System.out.println(StringUtils.reverse("abc")); // cba

        System.out.println("=========================字符串为null时返回空字符串=========================");
        // public static String defaultString(String str)  字符串为null，则返回空字符串
        System.out.println(StringUtils.defaultString(null)); // ""
        System.out.println(StringUtils.defaultString("")); // ""
        System.out.println(StringUtils.defaultString(" ")); // " "
        System.out.println(StringUtils.defaultString("abc")); // abc

        System.out.println("=========================判断字符串是否包含字符序列，忽略大小写=========================");
        // public static boolean containsIgnoreCase(CharSequence str, CharSequence searchStr)
        System.out.println(StringUtils.containsIgnoreCase(null, "abc")); // false
        System.out.println(StringUtils.containsIgnoreCase("abc", null)); // false
        System.out.println(StringUtils.containsIgnoreCase("", "abc")); // false
        System.out.println(StringUtils.containsIgnoreCase("abc", "")); // true
        System.out.println(StringUtils.containsIgnoreCase("aabca", "abc")); // true
        System.out.println(StringUtils.containsIgnoreCase("aaBca", "abc")); // true

        System.out.println("=========================截取子串=========================");
        // public static String substringBefore(final String str, final String separator)  分隔符第一次出现位置向前截取
        System.out.println(StringUtils.substringBefore("12,345,6789,112233", ",")); // 12
        // public static String substringBeforeLast(final String str, final String separator)  分隔符最后一次出现位置向前截取
        System.out.println(StringUtils.substringBeforeLast("12,345,6789,112233", ",")); // 12,345,6789
        // public static String substringAfter(final String str, final String separator)  分隔符第一次出现位置向后截取
        System.out.println(StringUtils.substringAfter("12,345,6789,112233", ",")); // 345,6789,112233
        // public static String substringAfterLast(final String str, final String separator)  分隔符最后一次出现位置向后截取
        System.out.println(StringUtils.substringAfterLast("12,345,6789,112233", ",")); // 112233
    }
}
