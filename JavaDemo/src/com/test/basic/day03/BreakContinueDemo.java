package com.test.basic.day03;

/**
 * break场景
 * 1、switch语句：用于结束switch语句
 * 2、循环：用于终止当前所在循环
 * <p>
 * continue场景
 * 1、循环：用于结束本次当前所在循环
 * <p>
 * break或continue范围后不能有语句，语句无法被执行到
 */
public class BreakContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
                // System.out.println("hello");  // 编译错误，语句无法被执行到
            }
            System.out.print(i + "\t"); // 0 1 2
        }
        System.out.println("\n****************************");

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + "\t"); // 0 1 2 4 5 6 7 8 9
        }
        System.out.println("\n****************************");

        // 获取2个数的最大公约数、最小公倍数
        int a = 12;
        int b = 20;
        int min = Math.min(a,b);
        for (int i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("最大公约数为：" + i); // 最大公约数为：4
                break;
            }
        }

        int max = Math.max(a,b);
        for (int i = max; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println("最小公倍数为：" + i); // 最小公倍数为：60
                break;
            }
        }
    }
}
