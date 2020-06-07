package com.test.day08;

/**
 * 递归方法：方法自己调用自己
 * 2个要点：明确的结束条件(向已知的方向递归)；不断修改方法传入的参数
 * 递归方法容易引起内存溢出
 */
public class RecursiveMethodDemo05 {
    public static void main(String[] args) {
        System.out.println("1+2+3+...+100=" + getSum(100)); // 1+2+3+...+100=5050
        System.out.println(getValue(10)); // 10497
        System.out.println(fibonacciSequence(8)); //21
    }

    public static int getSum(int num) {
        if (num == 1) {
            return 1;
        }

        return num + getSum(num - 1);
    }

    /**
     * 已知 f(0)=1,f(1)=4, f(n+2)=2*f(n+1)+f(n)，n是大于等于0的正数，求 f(10)
     */
    public static int getValue(int num) {
        // f(n+2)=2*f(n+1)+f(n) -> f(n)=2*f(n-1)+f(n-2)
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 4;
        } else {
            return 2 * getValue(num - 1) + getValue(num - 2);
        }
    }

    /**
     * 斐波拉契数列 1、1、2、3、5、8、13、21、34
     *
     * @param num
     * @return
     */
    public static int fibonacciSequence(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
        }
    }
}
