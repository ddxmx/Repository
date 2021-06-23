package com.test.day05;

import java.util.Scanner;

/**
 * 统计正数和负数的个数，0表示结束程序
 * 无限循环可以通过if语句+break退出循环
 */
public class EndlessLoopDemo {
    public static void main(String[] args) {
        int positiveCount = 0;
        int negativeCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("统计正数和负数的个数，0表示结束程序");
        while (true) {   // for(;;)
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
                System.out.println(scanner.next() + "输入的错误，请输入数字");
            }
        }
        System.out.printf("正数 %s 个数，负数 %s 个数", positiveCount, negativeCount);
    }
}
