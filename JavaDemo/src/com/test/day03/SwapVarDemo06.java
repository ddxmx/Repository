package com.test.day03;

public class SwapVarDemo06 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        //变量交换，推荐方式
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1);//num1 = 20
        System.out.println("num2 = " + num2);//num2 = 10
        System.out.println("**********************************");

        //采用+、-方式
        num1 = 10;
        num2 = 20;
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("num1 = " + num1);//num1 = 20
        System.out.println("num2 = " + num2);//num2 = 10
        System.out.println("**********************************");

        //采用异或方式，一个数异或两次等于他本身
        num1 = 10;
        num2 = 20;
        num1 = num1 ^ num2; //10 ^ 20
        num2 = num1 ^ num2;// 10 ^ 20 ^ 20 = 10
        num1 = num1 ^ num2;//10 ^ 20 ^ 10 = 20
        System.out.println("num1 = " + num1);//num1 = 20
        System.out.println("num2 = " + num2);//num2 = 10
    }
}
