package com.test.io.day17.stream.print;

import java.util.Scanner;

/**
 * 标准输入输出流
 * System.in：键盘输入
 * System.out：控制台输出
 * System.err：控制台错误输出
 */
public class SystemSteamDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("请输入数字，自动求和，输入-1结束程序");
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value == -1) {
                    System.out.println("结束运行~");
                    break;
                }
                sum += value;
                System.out.println("总和：" + sum);
            } else {
                System.out.println("当前输入非法，请重新输入");
                scanner.next();
            }
        }
    }
}
