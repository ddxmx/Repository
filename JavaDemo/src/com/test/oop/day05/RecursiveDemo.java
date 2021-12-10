package com.test.oop.day05;

/**
 * 方法的递归调用：方法自己调用自己
 * 方法递归的两个要点：
 * |- 明确的结束条件（向已知的方向递归）
 * |- 不断修改方法传入的参数
 * 递归方法容易引起栈内存溢出
 */
public class RecursiveDemo {
    public static void main(String[] args) {
        System.out.println(sum(100)); // 5050
        System.out.println(operating(10)); // 10497
        System.out.println(fibonacciSequence(8)); // 21
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
     * 已知 f(0)=1,f(1)=4, f(n+2)=2*f(n+1)+f(n)，n是大于等于0的正数，求 f(10)
     */
    public static int operating(int num) {
        // f(n+2)=2*f(n+1)+f(n) -> f(n)=2*f(n-1)+f(n-2)
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 4;
        } else {
            return 2 * operating(num - 1) + operating(num - 2);
        }
    }

    /**
     * 斐波拉契数列 1、1、2、3、5、8、13、21、34
     * f(x) = f(x-1) + f(x-2)
     */
    public static int fibonacciSequence(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
    }
}
