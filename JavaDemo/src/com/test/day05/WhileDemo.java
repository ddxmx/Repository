package com.test.day05;

/**
 * 不知道循环的次数，但是知道循环终止的条件，使用while循环
 * while循环控制变量，超过了while的范围，循环控制变量仍然可以使用
 */
public class WhileDemo {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1+2+3+...+99+100=" + sum); //1+2+3+...+99+100=5050

        while (true){
            System.out.println("无限循环");
        }
    }
}
