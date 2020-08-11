package com.test.day03;

/**
 * 逻辑运算符
 * 使用&或&&，|或||，运算结果相同
 * 开发中推荐使用 &&和||
 */
public class LogicOperDemo {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        System.out.println(a & b); //false
        System.out.println(a && b); //false
        System.out.println(a | b); //true
        System.out.println(a || b); //true
        System.out.println(a ^ b); //true，相同为false，不同为true
        System.out.println(!a); //false

        int num1 = 10;
        int num2 = 20;
        //所有条件都进行判断
        if (num1 == 10 | num2++ != 0) {
            System.out.printf("num1=%s，num2=%s\n", num1, num2); //num1=10,num2=21
        }

        num1 = 10;
        num2 = 20;
        // ||操作，运算符左右结果为true，运算符右边不再进行运算
        if (num1 == 10 || num2++ != 0) {
            System.out.printf("num1=%s，num2=%s\n", num1, num2); //num1=10,num2=20
        }
    }
}
