package com.test.basic.day02;

/**
 * 三元运算符
 * 三元运算符的优先级次低，仅高于赋值运算符
 * 关于运算符优先级：一元运算符 > 二元运算符(算术运算符优先级最高，三元运算符优先级次低，赋值运算符优先级最低)
 * <p>
 * 三元运算符都可以使用if-else替换，三元运算符格式：布尔表达式？表达式1:表达式2
 * 条件成立，运算结果取值表达式1；条件不成立，运算结果取值表达式2
 * 三元运算符肯定有返回值
 * 三元运算符可以嵌套使用
 */
public class TernaryOperatorDemo {
    public static void main(String[] args) {
        // 编译错误，不是表达式
        // System.out.println(true ? System.out.println(1) : System.out.println(2));

        int a = 10;
        int b = 20;
        // 获取两个数字的最大值
        int max = a > b ? a : b;
        System.out.println(max); // 20

        // 类型可以不一致，实际上都是Object的子类，数字自动装箱为Integer
        Object value = "hello".isEmpty() ? "abc" : 2;
        System.out.println(value); // 2

        int c = 25;
        int temp = 0;
        // 获取三个数中的最大值
        max = (temp = a > b ? a : b) > c ? temp : c;
        System.out.println(max); // 25

        // Math类对两个数字大小比较的支持
        int maxValue = Math.max(10, 12);
        int minValue = Math.min(21, 16);
        System.out.println(maxValue); // 12
        System.out.println(minValue); // 16
    }
}
