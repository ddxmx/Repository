package com.test.day07;

import java.util.Arrays;

/**
 * 冒泡排序
 * 第1次排序：[21, 38, 64, 14, 33, 72, 35, 23, 96]
 * 第2次排序：[21, 38, 14, 33, 64, 35, 23, 72, 96]
 * 第3次排序：[21, 14, 33, 38, 35, 23, 64, 72, 96]
 * 第4次排序：[14, 21, 33, 35, 23, 38, 64, 72, 96]
 * 第5次排序：[14, 21, 33, 23, 35, 38, 64, 72, 96]
 * 第6次排序：[14, 21, 23, 33, 35, 38, 64, 72, 96]
 * 第7次排序：[14, 21, 23, 33, 35, 38, 64, 72, 96]
 * 第8次排序：[14, 21, 23, 33, 35, 38, 64, 72, 96]
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 64, 38, 96, 14, 33, 72, 35, 23};

        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) { //n个元素，最多需要排序n-1轮
            for (int j = 0; j < arr.length - 1 - i; j++) { //每次排序后较大的值被排序到最后
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }

        System.out.println("***********************************");

        /*
            另一种排序实现，每轮找出一个最小的排序放在开头
            第1次排序：[14, 64, 38, 96, 21, 33, 72, 35, 23]
            第2次排序：[14, 21, 64, 96, 38, 33, 72, 35, 23]
            第3次排序：[14, 21, 23, 96, 64, 38, 72, 35, 33]
            第4次排序：[14, 21, 23, 33, 96, 64, 72, 38, 35]
            第5次排序：[14, 21, 23, 33, 35, 96, 72, 64, 38]
            第6次排序：[14, 21, 23, 33, 35, 38, 96, 72, 64]
            第7次排序：[14, 21, 23, 33, 35, 38, 64, 96, 72]
            第8次排序：[14, 21, 23, 33, 35, 38, 64, 72, 96]
         */
        arr = new int[]{21, 64, 38, 96, 14, 33, 72, 35, 23};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }
}