package com.test.basic.day07;

import java.util.Arrays;

/**
 * 一维数组和二维数组的反转
 */
public class ArrayReverseDemo {
    public static void main(String[] args) {
        // 一维数组反转
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 只需要交换数组一半的元素即可实现所有元素反转
        int head = 0;
        int tail = arr1.length - 1;
        for (int i = 0; i < arr1.length / 2; i++) {
            int temp = arr1[head];
            arr1[head] = arr1[tail];
            arr1[tail] = temp;
            head++;
            tail--;
        }
        System.out.println(Arrays.toString(arr1)); // [9, 8, 7, 6, 5, 4, 3, 2, 1]

        /*
            1	4	7
            2	5	8
            3	6	9
         */
        // 二维数组反转
        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr2.length; i++) {
            // 沿着左上右下对角线反转
            for (int j = 0; j < i; j++) {
                int temp = arr2[i][j];
                arr2[i][j] = arr2[j][i];
                arr2[j][i] = temp;
            }
        }

        // 遍历二维数组
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
