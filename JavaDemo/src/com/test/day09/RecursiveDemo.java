package com.test.day09;

/**
 * 方法的递归调用
 * 递归方法：方法自己调用自己
 * 2个要点：明确的结束条件(向已知的方向递归)；不断修改方法传入的参数
 * 递归方法容易引起内存溢出
 */
public class RecursiveDemo {
    public static void main(String[] args) {
        System.out.println("1+2+3+...+100=" + sum(100)); // 1+2+3+...+100=5050
        System.out.println(getValue(10)); // 10497
        System.out.println(fibonacciSequence(8)); //21
    }

    /**
     * 计算 1~num的和
     *
     * @param num
     * @return
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
            //当前位置的值=前2个位置的值之和
            return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
        }
    }
}
