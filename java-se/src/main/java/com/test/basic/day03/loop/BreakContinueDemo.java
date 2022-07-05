package com.test.basic.day03.loop;

/**
 * break场景
 * 1、switch语句：用于结束switch语句
 * 2、循环：用于终止当前所在层的循环，跳出循环
 * continue场景
 * 1、循环：用于结束本轮当前所在层的循环，继续下一轮循环
 * <p>
 * break或continue范围后不能有语句，语句无法被执行到
 */
public class BreakContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
                // 编译错误，break后的语句无法被执行到
                // System.out.println("hello");
            }
            System.out.print(i + "\t"); // 0 1 2
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            // 只结束本轮一次循环
            if (i == 3) {
                continue;
            }
            System.out.print(i + "\t"); // 0 1 2 4 5 6 7 8 9
        }
        System.out.println();

        // while循环中使用break、continue，修改循环控制变量要写在break、continue之前
        int j = 0;
        while (j < 10) {
            if (j == 3) {
                j++;
                continue;
            }
            System.out.print(j + "\t"); // 0 1 2 4 5 6 7 8 9
            j++;
        }
        System.out.println();

        // 获取2个数的最大公约数、最小公倍数
        int a = 12;
        int b = 20;
        // 最大公约数不会超过2个数中较小的数
        int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("最大公约数为：" + i); // 最大公约数为：4
                break;
            }
        }

        // 最小公倍数最小为2个数中较大的数，最大为2个数的乘积
        int max = Math.max(a, b);
        for (int i = max; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println("最小公倍数为：" + i); // 最小公倍数为：60
                break;
            }
        }
    }
}
