package com.test.basic.day03.jump;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5）
 * 123456789
 * 2 3 3 5 3607 3803
 */
public class PrimeNumberDemo {
    public static void main(String[] args) {
        System.out.println("请输入int范围的正整数");
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int input = sc.nextInt();

            if (1 == input) {
                return;
            }

            outer:
            while (true) {
                // 判断输入的数是否有因子
                for (int i = 2; i <= Math.sqrt(input); i++) {
                    if (input % i == 0) {
                        System.out.print(i + " ");
                        input /= i;
                        continue outer;
                    }
                }

                // 输入的数没有因子
                System.out.println(input);
                break;
            }
        }
    }
}
