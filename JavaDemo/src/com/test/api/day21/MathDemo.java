package com.test.api.day21;

/**
 * Math类
 */
public class MathDemo {
    public static void main(String[] args) {
        // 最大值
        System.out.println(Math.max(10, 20)); // 20

        // 最小值
        System.out.println(Math.min(10, 20)); // 10

        // 向下取值
        System.out.println(Math.floor(3.8)); // 3.0
        System.out.println(Math.floor(-3.8)); // -4.0

        // 向上取值
        System.out.println(Math.ceil(3.2)); // 4.0
        System.out.println(Math.ceil(-3.2)); // -3.0

        // 绝对值
        System.out.println(Math.abs(-1)); // 1
        System.out.println(Math.abs(1)); // 1

        // 随机数，范围[0,1)
        System.out.println(Math.random()); // 0.49422791378780184

        // +0.5后向下取整
        System.out.println(Math.round(1.5)); // 2
        System.out.println(Math.round(1.2)); // 1
        System.out.println(Math.round(-1.5)); // -1
        System.out.println(Math.round(-1.2)); // -1
    }
}
