package com.test.basic.day02;

/**
 * 逻辑运算符
 * 逻辑运算符的结果都是boolean类型
 * 使用&或&&，|或||，运算结果相同
 * &和|所有的条件都进行判断，不管运算符左边的结果是true还是false，右边都运算
 * &&：运算符左边为false时，右边不运算
 * ||：运算符左边为true时，右边不运算
 * 开发中推荐使用&&和||
 */
public class LogicOperatorDemo {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        System.out.println(a & b); // false
        System.out.println(a && b); // false
        System.out.println(a | b); // true
        System.out.println(a || b); // true
        // 异或，相同为false，不同为true
        System.out.println(a ^ b); // true
        System.out.println(!a); // false

        int num1 = 10;
        int num2 = 20;
        // |操作，所有条件都进行判断
        if (num1 > 0 | num2++ < 0) {
            System.out.println("num1=" + num1 + ",num2=" + num2); // num1=10,num2=21
        }

        num1 = 10;
        num2 = 20;
        // ||操作，运算符左边结果为true，右边不再进行运算
        if (num1 > 0 || num2++ < 0) {
            System.out.println("num1=" + num1 + ",num2=" + num2); // num1=10,num2=20
        }
    }
}
