package com.test.day04;

/**
 * 循环四个部分：
 * 初始化语句； 循环控制变量超过for循环的范围不能再使用
 * 循环条件判断；
 * 执行循环体
 * 修改循环控制变量。
 * 明确的知道循环的次数，使用for循环
 */
public class ForDemo04 {
    public static void main(String[] args) {
        //计算 1+2+3+...+99+100
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1+2+3+...+99+100=" + sum);  // 1+2+3+...+99+100=5050

        int sum2 = 0;
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum2 += i;
                count++;
                System.out.print(i + "、");
            }
        }
        System.out.println("\n1~100的偶数总和为：" + sum2); //sum2=2550
        System.out.println("1~100的偶数个数为：" + count); //sum2=2550
    }
}
