package com.test.basic.day02;

/**
 * 比较运算符
 * 比较运算符的结果都是boolean类型
 * 其中 >、>=、<、<=只能进行数值比较
 * ==和!=除了可以进行数值比较外，还可以进行引用数据类型内存地址比较
 */
public class CompareOperatorDemo02 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 4;
        System.out.println(num1 > num2); // true
        System.out.println(num1 >= num2); // true
        System.out.println(num1 < num2); // false
        System.out.println(num1 <= num2); // false
        System.out.println(num1 == num2); // false
        System.out.println(num1 != num2); // true

        // 引用数据类型，声明类型相同或存在父子关系时，才能使用==或!=
        Integer value1 = Integer.valueOf(100);
        Long value2 = Long.valueOf(100);
        // 编译错误，Integer类型和Long类型没有父子关系，不允许直接比较
        // System.out.println(value1 == value2);

        // 声明类型统一后，可以使用==或!=进行比较
        Object o1 = value1;
        Object o2 = value2;
        System.out.println(o1 == o2);
        System.out.println(o1 != o2);
    }
}
