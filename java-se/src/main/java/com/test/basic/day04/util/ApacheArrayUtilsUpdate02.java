package com.test.basic.day04.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 数组元素更新
 * Apache的ArrayUtils类扩展了java.util.Arrays类的能力
 * （1）对数据操作可能遇到的空指针异常进行了处理
 * （2）方法返回值返回了数组对象（新创建的对象，和传入的数组不是同一个对象），便于代码使用链式结构
 */
public class ApacheArrayUtilsUpdate02 {
    public static void main(String[] args) {
        int[] example = new int[]{1, 2, 3};
        int[] emptyArray = ArrayUtils.EMPTY_INT_ARRAY;
        int[] nullArray = null;

        System.out.println("--------------------------添加单个元素--------------------------");
        // add(int[] array,int ele) 将给定的数据添加到指定的数组中，返回一个新的数组
        print(ArrayUtils.add(example, 10)); // [1, 2, 3, 10]
        print(ArrayUtils.add(emptyArray, 10)); // [10]
        print(ArrayUtils.add(nullArray, 10)); // [10]

        System.out.println("--------------------------添加多个元素--------------------------");
        // addAll(int[] array, int... ele) 将给定的多个数据添加到指定的数组中，返回一个新的数组
        print(ArrayUtils.addAll(example, 10, 20, 30)); // [1, 2, 3, 10, 20, 30]
        print(ArrayUtils.addAll(emptyArray, 10, 20, 30)); // [10, 20, 30]
        print(ArrayUtils.addAll(nullArray, 10, 20, 30)); // [10, 20, 30]

        System.out.println("--------------------------插入多个元素--------------------------");
        // insert(int index, int[] array, int... values) 向指定的位置往该数组添加指定的元素，返回一个新的数组
        print(ArrayUtils.insert(2, example, 11, 22, 33)); // [1, 2, 11, 22, 33, 3]
        print(ArrayUtils.insert(0, emptyArray, 11, 22, 33)); // [11, 22, 33]
        print(ArrayUtils.insert(0, nullArray, 11, 22, 33)); // null

        System.out.println("--------------------------删除单个指定位置的元素--------------------------");
        // remove(int[] array, int index) 删除该数组指定位置上的元素，返回一个新的数组，所有后续元素左移（下标减1）
        print(ArrayUtils.remove(example, 1)); // [1, 3]
        // print(ArrayUtils.remove(emptyArray, 0)); // 编译通过，运行异常，java.lang.IndexOutOfBoundsException: Index: 0, Length: 0
        // print(ArrayUtils.remove(nullArray, 0)); // 编译通过，运行异常，java.lang.IndexOutOfBoundsException: Index: 0, Length: 0

        System.out.println("--------------------------删除多个指定位置的元素--------------------------");
        // removeAll(int[] array, int... index)  删除该数组指定位置上的元素，返回一个新的数组，所有后续元素左移（下标减1）
        print(ArrayUtils.removeAll(example, 0, 1)); // [3]
        // print(ArrayUtils.removeAll(emptyArray, 0)); // 编译通过，运行异常，java.lang.IndexOutOfBoundsException: Index: 0, Length: 0
        // print(ArrayUtils.removeAll(nullArray, 0)); // 编译通过，运行异常，java.lang.IndexOutOfBoundsException: Index: 0, Length: 0

        System.out.println("--------------------------删除单个指定的元素（在第一次出现的位置）--------------------------");
        int[] inputArray = {10, 11, 12, 11, 13, 14};
        // removeElement(int[] array, int element) 从该数组中删除指定的第一个元素，返回一个新的数组
        print(ArrayUtils.removeElement(inputArray, 11)); // [10, 12, 11, 13, 14]
        print(ArrayUtils.removeElement(emptyArray, 11)); // []
        print(ArrayUtils.removeElement(nullArray, 11)); // null

        System.out.println("--------------------------删除单个指定的元素（在所有出现的位置）--------------------------");
        // removeAllOccurences(int[] array, int element) 从该数组中删除指定的所有元素，返回一个新的数组
        print(ArrayUtils.removeAllOccurrences(inputArray, 11)); // [10, 12, 13, 14]
        print(ArrayUtils.removeAllOccurrences(emptyArray, 11)); // []
        print(ArrayUtils.removeAllOccurrences(nullArray, 11)); // null

        System.out.println("--------------------------删除多个指定的元素（在第一次出现的位置）--------------------------");
        // removeElements(int[] array, int... values) 从该数组中删除指定数量的元素，返回一个新的数组
        print(ArrayUtils.removeElements(inputArray, 11, 13)); // [10, 12, 11, 14]
        print(ArrayUtils.removeElements(emptyArray, 11, 13)); // []
        print(ArrayUtils.removeElements(nullArray, 11, 13)); // null
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
