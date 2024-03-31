package com.test.basic.day04.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * 数组类型转换
 * Apache的ArrayUtils类扩展了java.util.Arrays类的能力
 * （1）对数据操作可能遇到的空指针异常进行了处理
 * （2）方法返回值返回了数组对象（新创建的对象，和传入的数组不是同一个对象），便于代码使用链式结构
 */
public class ApacheArrayUtilsConvert01 {
    public static void main(String[] args) {
        int[] example = new int[]{1, 2, 3};
        int[] emptyArray = ArrayUtils.EMPTY_INT_ARRAY;
        int[] nullArray = null;

        System.out.println("--------------------------克隆数组--------------------------");
        // clone(int[] array) 复制数组并返回
        int[] cloneArray = ArrayUtils.clone(example);
        print(cloneArray); // [1, 2, 3]
        System.out.println(example == cloneArray); // false，复制出来的数组和原数组不是同一个数组
        print(ArrayUtils.clone(emptyArray)); // []
        print(ArrayUtils.clone(nullArray)); // null

        System.out.println("--------------------------截取数组，实际上就是数组拷贝--------------------------");
        // subarray(int[] array, int startIndexInclusive, int endIndexExclusive) 截取数组，按指定位置区间截取并返回一个新的数组
        print(ArrayUtils.subarray(example, 1, 2)); // [2]
        print(ArrayUtils.subarray(example, -1, 5)); // [1, 2, 3]
        print(ArrayUtils.subarray(emptyArray, 0, 1)); // []
        print(ArrayUtils.subarray(nullArray, 0, 1)); // null

        System.out.println("--------------------------将Object数组转换为Map--------------------------");
        // toMap(Object[] array) 将二维数组转换成Map并返会Map
        Map<Object, Object> colorMap = ArrayUtils.toMap(new String[][]{
                {"RED", "#FF0000"},
                {"GREEN", "#00FF00"},
                {"BLUE", "#0000FF"}}
        );
        System.out.println(colorMap); // {RED=#FF0000, GREEN=#00FF00, BLUE=#0000FF}

        System.out.println("--------------------------将Object数组转换为String数组--------------------------");
        // toStringArray(Object[] array) 将Object数组转换为String数组类型
        print(ArrayUtils.toStringArray(new Object[]{"java", "python", "c++"})); // [java, python, c++]

        System.out.println("--------------------------将基本数据类型数组转换为对象类型数组--------------------------");
        // toObject(boolean[] array) 将基本类型数组转换成对象类型数组并返回
        Integer[] integersExample = ArrayUtils.toObject(example);
        print(integersExample); // [1, 2, 3]

        System.out.println("--------------------------将对象类型数组转换为基本数据类型数组--------------------------");
        // toPrimitive(Boolean[] array) 将对象类型数组转换成基本类型数组并返回
        int[] intExample = ArrayUtils.toPrimitive(integersExample);
        print(intExample); // [1, 2, 3]

        System.out.println("--------------------------将数组转换为字符串表示--------------------------");
        // toString(Object array) 将数组转换为string字符串并返回，Arrays.toString()使用[]表示的
        System.out.println(ArrayUtils.toString(example)); // {1,2,3}
        System.out.println(ArrayUtils.toString(new Integer[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}})); // {{1,2},{3,4,5},{6,7,8,9}}
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print(Object[] array) {
        System.out.println(Arrays.toString(array));
    }
}
