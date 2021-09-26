package com.test.basic.day07;

import java.util.Arrays;

/**
 * 数组元素查找
 */
public class ArraySearchDemo {
    public static void main(String[] args) {
        int[] array = new int[]{21, 64, 38, 96, 14, 33, 72, 35, 23};
        // 要查找的key
        int key = 33;
        // 查找索引结果，未查找到返回-1
        int index = -1;

        // 线性查找
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                index = i;
                // 找到后结束查找
                break;
            }
        }
        System.out.println(index); // 5

        /*
         * 二分法查找
         * 二分法查找前提：数组是已经排序过的数组
         */
        // 数组排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // [14, 21, 23, 33, 35, 38, 64, 72, 96]
        // 调用API方式
        System.out.println(Arrays.binarySearch(array, key)); // 3
        // 手工实现二分法查找
        int head = 0;
        int tail = array.length - 1;
        while (head <= tail) {
            int center = (head + tail) / 2;
            if (key < array[center]) {
                tail = center - 1;
            } else if (key > array[center]) {
                head = center + 1;
            } else {
                index = center;
                break;
            }
        }
        System.out.println(index); // 3
    }
}
