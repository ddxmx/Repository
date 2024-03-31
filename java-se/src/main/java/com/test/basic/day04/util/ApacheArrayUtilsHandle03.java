package com.test.basic.day04.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 数组常用操作
 * Apache的ArrayUtils类扩展了java.util.Arrays类的能力
 * （1）对数据操作可能遇到的空指针异常进行了处理
 * （2）方法返回值返回了数组对象（新创建的对象，和传入的数组不是同一个对象），便于代码使用链式结构
 */
public class ApacheArrayUtilsHandle03 {
    public static void main(String[] args) {
        int[] example = new int[]{1, 2, 3};
        int[] emptyArray = ArrayUtils.EMPTY_INT_ARRAY;
        int[] nullArray = null;

        System.out.println("--------------------------查找元素--------------------------");
        // indexOf(int[] array, int valueToFind) 从数组的第一位开始查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1
        System.out.println(ArrayUtils.indexOf(example, 2)); // 1
        System.out.println(ArrayUtils.indexOf(example, 10)); // -1
        System.out.println(ArrayUtils.indexOf(emptyArray, 10)); // -1
        System.out.println(ArrayUtils.indexOf(nullArray, 10)); // -1

        System.out.println("--------------------------反向查找元素--------------------------");
        // lastIndexOf(int[] array, int valueToFind) 从数组的最后一位开始往前查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1
        int[] inputArray = new int[]{11, 22, 33, 11, 44, 55};
        System.out.println(ArrayUtils.lastIndexOf(inputArray, 11)); // 3
        System.out.println(ArrayUtils.lastIndexOf(inputArray, 10)); // -1
        System.out.println(ArrayUtils.lastIndexOf(emptyArray, 10)); // -1
        System.out.println(ArrayUtils.lastIndexOf(nullArray, 10)); // -1

        System.out.println("--------------------------从指定位置开始，反向查找元素--------------------------");
        // lastIndexOf(int[] array, int valueToFind, int startIndex) 从数组的startIndex位开始往前查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1
        System.out.println(ArrayUtils.lastIndexOf(inputArray, 11, 4)); // 3
        System.out.println(ArrayUtils.lastIndexOf(inputArray, 11, 2)); // 0
        System.out.println(ArrayUtils.lastIndexOf(inputArray, 10, 1)); // -1
        System.out.println(ArrayUtils.lastIndexOf(emptyArray, 10, 1)); // -1
        System.out.println(ArrayUtils.lastIndexOf(nullArray, 10, 1)); // -1

        System.out.println("--------------------------判断数组是否包含元素--------------------------");
        // contains(int[] array, int valueToFind) 检查该数据在该数组中是否存在，返回一个boolean值
        System.out.println(ArrayUtils.contains(example, 2)); // true
        System.out.println(ArrayUtils.contains(example, 10)); // false
        System.out.println(ArrayUtils.contains(emptyArray, 10)); // false
        System.out.println(ArrayUtils.contains(nullArray, 10)); // false

        System.out.println("--------------------------获取数组长度--------------------------");
        // getLength(int[] array) 返回该数组长度
        System.out.println(ArrayUtils.getLength(example)); // 3
        System.out.println(ArrayUtils.getLength(emptyArray)); // 0
        System.out.println(ArrayUtils.getLength(nullArray)); // 0

        System.out.println("--------------------------判断数组是否为空--------------------------");
        // isEmpty(int[] array) 判断该数组是否为空，返回一个boolean值
        System.out.println(ArrayUtils.isEmpty(example)); // false
        System.out.println(ArrayUtils.isEmpty(emptyArray)); // true
        System.out.println(ArrayUtils.isEmpty(nullArray)); // true

        System.out.println("--------------------------判断数组是否不为空--------------------------");
        // isNotEmpty(int[] array) 判断该数组是否不为空，返回一个boolean值
        System.out.println(ArrayUtils.isNotEmpty(example)); // true
        System.out.println(ArrayUtils.isNotEmpty(emptyArray)); // false
        System.out.println(ArrayUtils.isNotEmpty(nullArray)); // false

        System.out.println("--------------------------将null转换为空数组--------------------------");
        // nullToEmpty(int[] array) 将null转换为空的数组,如果数组不为null,返回原数组,如果数组为null,返回一个空的数组
        print(ArrayUtils.nullToEmpty(example)); // [1, 2, 3]
        print(ArrayUtils.nullToEmpty(emptyArray)); // []
        print(ArrayUtils.nullToEmpty(nullArray)); // []

        System.out.println("--------------------------判断两个数组长度是否相同--------------------------");
        // isSameLength(boolean[] array1, boolean[] array2) 判断两个数组的长度是否一样，当数组为空视长度为0。返回一个boolean值
        System.out.println(ArrayUtils.isSameLength(new int[]{11, 22, 33}, example)); // true
        System.out.println(ArrayUtils.isSameLength(emptyArray, example)); // false
        System.out.println(ArrayUtils.isSameLength(nullArray, emptyArray)); // true

        System.out.println("--------------------------数组反转（修改原数组）--------------------------");
        // reverse(boolean[] array) 数组反转
        int[] reverseArray = ArrayUtils.clone(example);
        ArrayUtils.reverse(reverseArray);
        print(reverseArray); // [3, 2, 1]
        // reverse(final Object[] array)
        int[][] reverseSecondArray = new int[][]{{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};
        ArrayUtils.reverse(reverseSecondArray);
        System.out.println(ArrayUtils.toString(reverseSecondArray)); // {{77,88,99},{44,55,66},{11,22,33}}

        System.out.println("--------------------------在指定区间内数组反转（修改原数组）--------------------------");
        // reverse(boolean[] array, int startIndexInclusive, int endIndexExclusive) 数组从指定位置区间进行反转
        int[] reverseThirdArray = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        ArrayUtils.reverse(reverseThirdArray, 3, 7);
        print(reverseThirdArray); // [11, 22, 33, 77, 66, 55, 44, 88, 99]

        System.out.println("--------------------------将数组元素随机排序（修改原数组）--------------------------");
        // shuffle(boolean[] array) 把数组中的元素按随机顺序重新排列
        int[] shuffleArray = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        ArrayUtils.shuffle(shuffleArray);
        print(shuffleArray); // [77, 22, 11, 99, 44, 33, 55, 88, 66]

        System.out.println("--------------------------交换数组中两个位置的元素（修改原数组）--------------------------");
        // swap(boolean[] array, int offset1, int offset2) 指定该数组的两个位置的元素交换进行交换
        int[] swapArray = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        ArrayUtils.swap(swapArray, 3, 7);
        print(swapArray); // [11, 22, 33, 88, 55, 66, 77, 44, 99]
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
