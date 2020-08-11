package com.test.day05;

import java.util.Scanner;

/**
 * 统计正数和负数的个数，0表示结束程序
 * 1
 * 2
 * -1
 * 3
 * -2
 * 0
 * 正数个数：3，负数个数：2
 */
public class LoopScanner {
    public static void main(String[] args) {
        int positiveCount = 0;
        int negativeCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("统计正数和负数的个数，0表示结束程序");
        while (true) {   // for(;;)
            int next = scanner.nextInt();
            if (next > 0) {
                positiveCount++;
            } else if (next < 0) {
                negativeCount++;
            } else {
                break;
            }
        }
        System.out.printf("正数 %s 个数，负数 %s 个数", positiveCount, negativeCount);
    }
}
