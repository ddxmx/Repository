package com.test.api.day21;

import java.util.Random;

/**
 * 随机数
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt()); // 生成随机整数
        System.out.println(random.nextInt(100)); // 成为[0,100)的整数
        System.out.println(random.nextInt(40 + 1) + 60); // 生成[60,100]随机数
    }
}
