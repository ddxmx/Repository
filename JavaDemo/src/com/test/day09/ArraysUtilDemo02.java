package com.test.day09;

class ArraysUtil {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static int avg(int[] arr) {
        return sum(arr) / arr.length;
    }

    public static void reverse(int[] arr) {
        int head = 0;
        int tail = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head++;
            tail--;
        }
    }

    public static int[] copy(int[] arr) {
        int[] dest = new int[arr.length];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = arr[i];
        }

        return dest;
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "，");
        }
        System.out.println();
    }

    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}

public class ArraysUtilDemo02 {
    public static void main(String[] args) {
        int[] array = new int[]{31, 27, 84, 55, 62, 19, 33};
        System.out.println(ArraysUtil.max(array)); // 84
        System.out.println(ArraysUtil.min(array)); // 19
        System.out.println(ArraysUtil.sum(array)); // 311
        System.out.println(ArraysUtil.avg(array)); // 44
        ArraysUtil.reverse(array);
        ArraysUtil.print(array); // 33，19，62，55，84，27，31，
        ArraysUtil.sort(array);
        ArraysUtil.print(array); // 19，27，31，33，55，62，84，
        System.out.println(ArraysUtil.search(array, 55)); // 4
        System.out.println(ArraysUtil.search(array, 99)); // -1
    }
}
