package com.test.api.day15.random.util;

import org.apache.commons.lang3.RandomUtils;

public class ApacheRandomUtils {
    public static void main(String[] args) {
        // 生成[0,Integer.MAX_VALUE)之间的随机int值
        System.out.println(RandomUtils.nextInt());

        // 生成[startInclusive,endExclusive)之间的随机int值
        System.out.println(RandomUtils.nextInt(1, 100));

        // 生成随机boolean值
        System.out.println(RandomUtils.nextBoolean());
    }
}
