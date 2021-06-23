package com.test.day05;

/**
 * do-while循环先执行一次循环体，再根据循环条件是否满足来决定是否继续执行循环体
 * |-while循环条件不满足时，循环主体一次都不执行
 * |-do-while循环条件不满足时，循环主体也会执行一次
 */
public class DoWhileDemo {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        do {
            sum += i;
            i++;
        } while (i <= 100);

        System.out.println("1+2+3+...+100=" + sum); //1+2+3+...+100=5050
    }
}
