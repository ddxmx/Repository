package com.test.api.day15.math;

/**
 * Math类
 * Math类中的方法都是静态方法
 */
public class MathDemo {
    public static void main(String[] args) {
        // 最大值
        // public static int max(int a, int b)
        System.out.println(Math.max(10, 20)); // 20

        // 最小值
        // public static int min(int a, int b)
        System.out.println(Math.min(10, 20)); // 10

        // 向下取值
        // public static double floor(double a)
        System.out.println(Math.floor(3.8)); // 3.0
        System.out.println(Math.floor(-3.8)); // -4.0

        // 向上取值
        // public static double ceil(double a)
        System.out.println(Math.ceil(3.2)); // 4.0
        System.out.println(Math.ceil(-3.2)); // -3.0

        // 绝对值
        // public static int abs(int a)
        System.out.println(Math.abs(-1)); // 1
        System.out.println(Math.abs(1)); // 1

        // 乘方
        // public static double pow(double a, double b)
        System.out.println(Math.pow(2, 3)); // 8

        // 随机数，范围[0,1)
        // public static double random()
        System.out.println(Math.random()); // 0.49422791378780184

        // 四舍五入，+0.5后向下取整
        // public static long round(double a)
        System.out.println(Math.round(1.5)); // 2
        System.out.println(Math.round(1.2)); // 1
        System.out.println(Math.round(-1.5)); // -1
        System.out.println(Math.round(-1.2)); // -1
    }
}
