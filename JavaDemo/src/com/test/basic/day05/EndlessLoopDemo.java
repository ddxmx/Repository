package com.test.basic.day05;

import java.util.Scanner;

/**
 * 统计正数和负数的个数，0表示结束程序
 * 无限循环可以通过if语句+break退出循环
 */
public class EndlessLoopDemo {
    public static void main(String[] args) {
        // 正数数量
        int positiveCount = 0;
        // 负数数量
        int negativeCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("统计正数和负数的个数，0表示结束程序");
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) {
                    positiveCount++;
                } else if (value < 0) {
                    negativeCount++;
                } else {
                    break;
                }
            } else {
                scanner.next();
                System.out.println("输入错误，请输入数字");
            }
        }
        System.out.println("正数" + positiveCount + "个，负数" + negativeCount + "个");
    }
}
