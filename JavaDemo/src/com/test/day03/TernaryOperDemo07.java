package com.test.day03;

/**
 * 三元运算符都可以使用if-else替换，三元运算符格式如下
 * 布尔表达式？表达式1:表达式2
 * 条件成立，运算符结果取值表达式1；条件不成立，运算结果取值表达式2
 * 三元运算符肯定有返回值
 * 以下的编译无法正常通过，无法使用变量进行接收
 * true?System.out.println(true):System.out.println(false);
 * <p>
 * 关于运算符优先级：一元运算符 > 二元运算符(算术运算符最高，三元运算符优先级次低，赋值运算符优先级最低)
 */
public class TernaryOperDemo07 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //计算2个数字的最大值
        int max = a > b ? a : b;
        System.out.println(max);  //20

        //类型可以不一致，实际上都是Object的子类，数字自动装箱为Integer
        System.out.println(false ? 2 : "abc"); //abc

        int c = 15;
        int temp = 0;
        //获取三个数中的最大值
        max = (temp = (a > b) ? a : b) > c ? temp : c;
        System.out.println(temp);  //20
    }
}
