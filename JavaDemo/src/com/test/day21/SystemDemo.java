package com.test.day21;

import java.util.Arrays;

/**
 * System类
 */
public class SystemDemo {
    public static void main(String[] args) {
        //获取当前时间戳
        System.out.println(System.currentTimeMillis()); //1612799213856

        //数组复制
        int[] arr1 = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.arraycopy(arr1, 2, arr2, 3, 3);
        System.out.println(Arrays.toString(arr2)); //[1, 2, 3, 33, 44, 55, 7, 8, 9]

        //建议GC回收
        System.gc();

        //获取系统配置
        System.out.println(System.getProperty("java.version")); //1.8.0_261
        System.out.println(System.getProperty("java.class.version")); //52.0
        System.out.println(System.getProperty("java.home")); //D:\Java\jdk1.8.0_261\jre
        System.out.println(System.getProperty("user.home")); //C:\Users\Yu
        System.out.println(System.getProperty("user.dir")); //e:\IdeaProjects\java-basic

        //0表示正常退出，1表示异常退出
        System.exit(0);

        //退出后的语句无法执行到
        System.out.println("hello world");
    }
}
