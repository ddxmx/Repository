package com.test.day04;

import java.util.Scanner;

/**
 * Scanner类用于从键盘获取输入值
 * next()、nextInt()、nextDouble() 、nextLine()、next(String pattern)
 */
public class ScannerDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value < 0 || value > 100) {
                System.out.println("成绩输入错误");
            } else if (value == 100) {
                System.out.println("奖励一辆汽车");
            } else if (value >= 90) {
                System.out.println("奖励一个手机");
            } else if (value >= 60) {
                System.out.println("奖励一个平板");
            } else {
                System.out.println("不及格，什么也没有");
            }
        } else {
            System.out.println("成绩必须为整数");
        }
    }
}
