package com.test.day05;

/**
 * while循环条件不满足时，循环主体一次都不执行
 * do-while循环条件不满足时，循环主体也会执行一次
 */
public class DoWhileDemo02 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 100);
        System.out.println("1+2+3+...+99+100=" + sum);//1+2+3+...+99+100=5050
    }
}
