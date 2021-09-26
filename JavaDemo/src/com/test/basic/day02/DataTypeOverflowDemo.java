package com.test.basic.day02;

/**
 * 数据溢出的解决方式：扩大数据类型
 */
public class DataTypeOverflowDemo {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE; // int类型的最大值
        int min = Integer.MIN_VALUE; // int类型的最小值
        System.out.println("int类型最大值：" + max);
        System.out.println("int类型最小值：" + min);

        // 出现数据溢出
        System.out.println("最大值 + 1 = " + (max + 1)); // 最大值 + 1 = 最小值，-2147483648
        System.out.println("最大值 + 2 = " + (max + 2)); // 最大值 + 2 = 次小值，-2147483647
        System.out.println("最小值 - 1 = " + (min - 1)); // 最小值 - 1 = 最大值，2147483647

        // 扩大数据类型，解决数据溢出的问题
        System.out.println("最大值 + 1 = " + ((long) max + 1)); // 最大值 + 1 = 2147483648
        System.out.println("最大值 + 2 = " + (max + 2L)); // 最大值 + 2 = 2147483649
        System.out.println("最小值 - 1 = " + (min - (long) 1)); // 最小值 - 1 = -2147483649
    }
}
