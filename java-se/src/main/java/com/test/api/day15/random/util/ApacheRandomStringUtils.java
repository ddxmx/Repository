package com.test.api.day15.random.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 底层也是使用 java.util.Random
 */
public class ApacheRandomStringUtils {
    public static void main(String[] args) {
        System.out.println("=====================随机数，指定长度，是否包含字母或数字=====================");
        // public static String random(final int count, final boolean letters, final boolean numbers)
        System.out.println(RandomStringUtils.random(8, true, true));

        System.out.println("=====================随机数，指定长度，包含的字符范围=====================");
        // public static String random(final int count, final String chars)
        System.out.println(RandomStringUtils.random(8, "abcdefg12345"));

        System.out.println("=====================随机数，指定长度或长度范围，只包含大小写字母=====================");
        // public static String randomAlphabetic(final int count)
        System.out.println(RandomStringUtils.randomAlphabetic(8));
        // public static String randomAlphabetic(final int minLengthInclusive, final int maxLengthExclusive)
        System.out.println(RandomStringUtils.randomAlphabetic(5, 10));

        System.out.println("=====================随机数，指定长度或长度范围，只包含数字=====================");
        // public static String randomNumeric(final int count)
        System.out.println(RandomStringUtils.randomNumeric(8));
        // public static String randomNumeric(final int minLengthInclusive, final int maxLengthExclusive)
        System.out.println(RandomStringUtils.randomNumeric(5, 10));

        System.out.println("=====================随机数，指定长度或长度范围，只包含大小写字母和数字=====================");
        // public static String randomAlphanumeric(final int count
        System.out.println(RandomStringUtils.randomAlphanumeric(8));
        System.out.println(RandomStringUtils.randomAlphanumeric(5, 10));
    }
}
