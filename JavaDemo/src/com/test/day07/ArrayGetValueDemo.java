package com.test.day07;

import java.util.Arrays;
import java.util.Random;

/**
 * [54, 53, 8, 17, 84, 87, 48, 59, 64, 12]
 * 最大值：87
 * 最小值：8
 * 总和：486
 * 平均值：48.6
 */
public class ArrayGetValueDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100); //[0,100)
        }
        System.out.println(Arrays.toString(arr)); //随机值 [54, 53, 8, 17, 84, 87, 48, 59, 64, 12]

        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        double avg = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];
        }

        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("总和：" + sum);
        System.out.println("平均值：" + (double) sum / arr.length);
    }
}
