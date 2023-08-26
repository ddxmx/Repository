package com.test.api.day15.system;

import java.util.Arrays;

/**
 * System类
 */
public class SystemDemo {
    public static void main(String[] args) {
        // 获取当前时间戳（毫秒）
        System.out.println(System.currentTimeMillis()); // 1612799213856
        // 用于衡量一个时间段，比如说一段代码执行所用的时间（纳秒，10^-3微秒，10^-6毫秒，10^-9秒）
        System.out.println(System.nanoTime());

        // 数组拷贝
        int[] srcArray = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] destArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.arraycopy(srcArray, 2, destArray, 3, 3);
        System.out.println(Arrays.toString(destArray)); // [1, 2, 3, 33, 44, 55, 7, 8, 9]

        // 建议GC回收
        System.gc();

        // 获取系统属性
        // 当前用户
        System.out.println(System.getProperty("user.name")); // Yu
        // 用户家目录
        System.out.println(System.getProperty("user.home")); // C:\Users\Yu
        // 用户当前工作目录
        System.out.println(System.getProperty("user.dir")); // E:\IdeaProjects\java-basic

        // 0表示正常退出，1表示异常退出，退出语句后的语句无法执行到
        System.exit(0);
    }
}
