package com.test.day07;

import java.util.Arrays;

/**
 * 数组元素查找
 */
public class ArraySearchDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 64, 38, 96, 14, 33, 72, 35, 23};
        int key = 33;
        int index = -1; // 未查找到返回 -1

        //线性查找
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                index = i;
                //找到后结束查找
                break;
            }
        }
        System.out.println(index); //5

        //二分法查找
        //二分法查找前提：数组是已经排序过的数组
        Arrays.sort(arr); // 数组排序
        System.out.println(Arrays.toString(arr)); // [14, 21, 23, 33, 35, 38, 64, 72, 96]
        //调用API方式
        System.out.println(Arrays.binarySearch(arr, key)); //3
        //手工实现二分法查找
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int center = (head + tail) / 2;
            if (key < arr[center]) {
                tail = center - 1;
            } else if (key > arr[center]) {
                head = center + 1;
            } else {
                index = center;
                break;
            }
        }
        System.out.println(index); //3
    }
}
