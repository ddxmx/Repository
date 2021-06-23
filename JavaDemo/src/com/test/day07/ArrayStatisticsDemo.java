package com.test.day07;

import java.util.Arrays;
import java.util.Random;

/**
 * 生成10个随机数，获取其中最大值、最小值、总和、平均值
 */
public class ArrayStatisticsDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            //生成0~100的随机数
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr)); //[15, 57, 50, 14, 99, 98, 55, 21, 14, 79]

        //最大值
        int max = arr[0];
        //最小值
        int min = arr[0];
        //总和
        int sum = 0;
        //平均值
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
        avg = (double) sum / arr.length;

        System.out.println("最大值：" + max); //最大值：99
        System.out.println("最小值：" + min); //最小值：14
        System.out.println("总和：" + sum); //总和：502
        System.out.println("平均值：" + avg); //平均值：50.2
    }
}
