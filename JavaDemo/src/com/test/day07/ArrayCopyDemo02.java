package com.test.day07;

import java.util.Arrays;

/**
 * 数组拷贝
 */
public class ArrayCopyDemo02 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};

        int copyLength = 3;
        int originalA = 2;
        int originalB = 3;
        for (int i = 0; i < copyLength; i++) {
            b[originalB + i] = a[originalA + i];
        }
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]


        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.arraycopy(a, originalA, b, originalB, copyLength);
        System.out.println(Arrays.toString(b)); // [11, 22, 33, 3, 4, 5, 77, 88, 99]
    }
}
