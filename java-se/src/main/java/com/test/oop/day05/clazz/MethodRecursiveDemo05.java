package com.test.oop.day05.clazz;

/**
 * 方法的递归调用：方法自己调用自己
 * 1、方法递归的两个条件：
 * （1）明确的结束条件（向已知的方向递归）
 * （2）不断修改方法传入的参数
 * 2、递归方法容易引起栈内存溢出
 */
public class MethodRecursiveDemo05 {
    public static void main(String[] args) {
        System.out.println(sum(100)); // 5050
        System.out.println(factorial(10)); // 3628800
        System.out.println(func(10)); // 10497
        System.out.println(fibonacciSequence(8)); // 21
        System.out.println(jump(30)); // 58425
    }

    /**
     * 计算 1累加到num的和
     */
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }

        return num + sum(num - 1);
    }

    /**
     * 计算 n的阶乘
     */
    public static long factorial(int num) {
        if (num == 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    /**
     * 已知 f(0)=1,f(1)=4, f(n+2)=2*f(n+1)+f(n)，n是大于等于0的正数，求 f(10)
     */
    public static int func(int num) {
        // f(n+2)=2*f(n+1)+f(n) -> f(n)=2*f(n-1)+f(n-2)
        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 4;
        }

        return 2 * func(num - 1) + func(num - 2);
    }

    /**
     * 斐波拉契数列 1、1、2、3、5、8、13、21、34，求第n（n从1开始）个位置上的值
     */
    public static int fibonacciSequence(int num) {
        // f(x) = f(x-1) + f(x-2)，f(1)=1，f(2)=1
        if (num == 1 || num == 2) {
            return 1;
        }

        return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
    }

    /**
     * 一个顽猴在一座有30级台阶的小山上爬山活跃，猴子上一步可跳1级或者3级，试求上山的30级台阶有多少种不同的爬法
     */
    public static int jump(int step) {
        // f(k) = f(k-1) + f(k-3)，f(1)=1，f(2)=1，f(3)=2
        if (step == 1 || step == 2) {
            return 1;
        }

        if (step == 3) {
            return 2;
        }

        return jump(step - 1) + jump(step - 3);
    }
}
