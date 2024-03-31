package com.test.basic.day04.operator;

import java.util.Arrays;

/**
 * 数组翻转
 */
public class ArrayReverseDemo02 {
    public static void main(String[] args) {
        // 一维数组翻转
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 只需要交换数组一半的元素即可实现所有元素翻转
        for (int i = 0; i < arr1.length / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[arr1.length - 1 - i];
            arr1[arr1.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr1)); // [9, 8, 7, 6, 5, 4, 3, 2, 1]

        /*
            1	4	7
            2	5	8
            3	6	9
         */
        // 二维数组翻转，前提：二维数组行和列长度一致
        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr2.length; i++) {
            // 沿着左上右下对角线翻转
            for (int j = 0; j < i; j++) {
                int temp = arr2[i][j];
                arr2[i][j] = arr2[j][i];
                arr2[j][i] = temp;
            }
        }
        // 遍历二维数组
        System.out.println(Arrays.toString(arr2)); // [[I@511d50c0, [I@60e53b93, [I@5e2de80c]
        System.out.println(Arrays.deepToString(arr2)); // [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
    }
}
