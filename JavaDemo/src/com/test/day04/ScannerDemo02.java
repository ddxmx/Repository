package com.test.day04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入三个数字，排序
 */
public class ScannerDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int first = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int second = scanner.nextInt();
        System.out.println("请输入第三个数字");
        int third = scanner.nextInt();

        int[] array = new int[]{first, second, third};
        Arrays.sort(array);
        System.out.println("三个数字从小到大排序：" + Arrays.toString(array));
    }
}
