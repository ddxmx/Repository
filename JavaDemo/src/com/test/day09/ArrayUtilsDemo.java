package com.test.day09;

import java.util.Arrays;

/**
 * 数组工具类
 */
class ArrayUtils {

    /**
     * 获取数组中最大值
     *
     * @param array
     * @return
     */
    public int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }


    /**
     * 获取数组中最小值
     *
     * @param array
     * @return
     */
    public int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 获取数组中元素总和
     *
     * @param array
     * @return
     */
    public int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * 获取数组的平均值
     *
     * @param array
     * @return
     */
    public int getAvg(int[] array) {
        return getSum(array) / array.length;
    }

    /**
     * 数组反转
     *
     * @param array
     */
    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * 数组拷贝
     *
     * @param array
     * @return
     */
    public int[] copy(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    /**
     * 数组排序
     *
     * @param array
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 数组遍历打印
     *
     * @param array
     */
    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 数组元素查找
     *
     * @param array
     * @param key
     * @return
     */
    public int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]) {
                return i;
            }
        }
        return -1;
    }
}

public class ArrayUtilsDemo {
    public static void main(String[] args) {
        int[] array = new int[]{11, 35, 21, 7, 84, 22, 53, 86};
        ArrayUtils utils = new ArrayUtils();
        System.out.println("最大值：" + utils.getMax(array)); //最大值：86
        System.out.println("最小值：" + utils.getMin(array)); //最小值：7
        System.out.println("总和：" + utils.getSum(array)); //总和：319
        System.out.println("平均值：" + utils.getAvg(array)); //平均值：39

        System.out.print("数组反转：");
        utils.reverse(array);
        utils.print(array); //数组反转：86	53	22	84	7	21	35	11

        System.out.print("数组拷贝：");
        int[] anoArray = utils.copy(array);
        System.out.println(Arrays.toString(anoArray)); //数组拷贝：[86, 53, 22, 84, 7, 21, 35, 11]
        anoArray[0] = 100;
        System.out.println("拷贝后新数组第一个元素：" + anoArray[0]); //拷贝后新数组第一个元素：100
        System.out.println("原数组第一个元素：" + array[0]); //原数组第一个元素：86

        System.out.print("数组排序：");
        utils.sort(array);
        utils.print(array); //数组排序：7	11	21	22	35	53	84	86

        System.out.println("数组元素查找：");
        System.out.println("22的索引位置：" + utils.search(array, 22)); //22的索引位置：3
        System.out.println("30的索引位置：" + utils.search(array, 30)); //30的索引位置：-1
    }
}
