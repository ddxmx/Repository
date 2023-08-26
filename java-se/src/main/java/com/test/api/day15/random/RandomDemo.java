package com.test.api.day15.random;

import java.util.Random;

/**
 * 伪随机数
 * Random的seed固定时，获取的随机数也相同
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();

        // public int nextInt()，生成int范围内随机数
        System.out.println(random.nextInt());
        // public int nextInt(int bound)，范围[0，bound)
        System.out.println(random.nextInt(100)); // 成为[0,100)的随机整数
        System.out.println(random.nextInt(40) + 60); // 生成[60,100)随机整数

        // public float nextFloat()，生成[0,1)之间的随机float小数
        System.out.println(random.nextFloat());
        // public double nextDouble()，生成[0,1)之间的随机double小数
        System.out.println(random.nextDouble());

        /*
            15	0	24	38	41	16	36	38	23	13
            15	0	24	38	41	16	36	38	23	13
            15	0	24	38	41	16	36	38	23	13
         */
        for (int i = 0; i < 3; i++) {
            // 指定随机数种子，种子相同，获取的随机数相同
            Random model = new Random(100);
            for (int j = 0; j < 10; j++) {
                System.out.print(model.nextInt(50) + "\t");
            }
            System.out.println();
        }
    }
}
