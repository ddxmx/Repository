package com.test.api.day14.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Apache的StringUtils类扩展了java.lang.String类的能力
 */
public class ApacheStringUtils {
    public static void main(String[] args) {
        // public static boolean isBlank(CharSequence cs)
        System.out.println(StringUtils.isBlank(null)); // true
        System.out.println(StringUtils.isBlank("")); // true
        System.out.println(StringUtils.isBlank(" ")); // true

        // public static boolean isEmpty(CharSequence cs)
        System.out.println(StringUtils.isEmpty(null)); // true
        System.out.println(StringUtils.isEmpty("")); // true
        System.out.println(StringUtils.isEmpty(" ")); // false

        // public static boolean isWhitespace(CharSequence cs)
        System.out.println(StringUtils.isWhitespace(null)); // false
        System.out.println(StringUtils.isWhitespace("")); // true
        System.out.println(StringUtils.isWhitespace(" ")); // true

        // public static String capitalize(String str)
        System.out.println(StringUtils.capitalize("hello")); // Hello
        System.out.println(StringUtils.capitalize("HELLO")); // HELLO
    }
}
