package com.test.basic.day04.operator;

import java.util.Arrays;

/**
 * 数组元素查找
 */
public class ArraySearchDemo03 {
    public static void main(String[] args) {
        int[] array = new int[]{21, 64, 38, 96, 14, 33, 72, 35, 23};
        // 要查找的key
        int key = 33;
        // 查找索引结果，未查找到返回-1
        int index = -1;

        // 方式一：线性查找，从头开始依次查找
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                index = i;
                break;
            }
        }
        System.out.println(index); // 5

        /*
         * 方式二：二分法查找（前提是数组已经正序排序）
         */
        // 数组排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // [14, 21, 23, 33, 35, 38, 64, 72, 96]
        // 调用Arrays类中binarySearch()方法实现
        System.out.println(Arrays.binarySearch(array, key)); // 3

        // 手工实现二分法查找
        int head = 0;
        int tail = array.length - 1;

        while (head <= tail) {
            int center = (head + tail) / 2;
            int centerValue = array[center];

            if (key < centerValue) { // 在前半部分
                tail = center - 1;
            } else if (key > centerValue) { // 在后半部分
                head = center + 1;
            } else { // 已找到
                index = center;
                break;
            }
        }
        System.out.println(index); // 3
    }
}
