package com.test.day07;

import java.util.Arrays;

/**
 * 数组反转
 * 一维数组、二维数组的反转
 */
public class ArrayReverseDemo {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int head = 0;
        int tail = arr1.length - 1;
        for (int i = 0; i < arr1.length / 2; i++) { //控制交换的次数
            int temp = arr1[tail];
            arr1[tail] = arr1[head];
            arr1[head] = temp;
            head++; //控制交换的数组索引
            tail--; //控制交换的数组索引
        }
        System.out.println(Arrays.toString(arr1)); // [9, 8, 7, 6, 5, 4, 3, 2, 1]

        /*
            1	4	7
            2	5	8
            3	6	9
         */
        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr2[i][j];
                arr2[i][j] = arr2[j][i];
                arr2[j][i] = temp;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
