package com.test.collection.day20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections是一个操作List、Set、Map的工具类
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 反转list，set和map是无序的，不提供支持
        Collections.reverse(list);
        System.out.println(list); // [9, 8, 7, 6, 5, 4, 3, 2, 1]

        // 随机排列list元素
        Collections.shuffle(list);
        System.out.println(list); // [5, 1, 6, 9, 2, 8, 3, 4, 7]

        list = Arrays.asList(5, 1, 6, 9, 2, 8, 3, 4, 7);
        // list排序
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // 交换list中元素位置
        Collections.swap(list, 1, 4);
        System.out.println(list); // [1, 5, 3, 4, 2, 6, 7, 8, 9]

        // 获取list中最大值
        System.out.println(Collections.max(list)); // 9

        // 获取list中最小值
        System.out.println(Collections.min(list)); // 1

        list = Arrays.asList(11, 22, 11, 33, 11, 44, 55);
        // 获取元素在list中出现的次数
        System.out.println(Collections.frequency(list, 11)); // 3

        List<Integer> list2 = Arrays.asList(new Integer[list.size()]);
        System.out.println(list2); // [null, null, null, null, null, null, null]
        // list拷贝,目标list必须有足够大小
        Collections.copy(list2, list);
        System.out.println(list2); // [11, 22, 11, 33, 11, 44, 55]

        // Collections中存在多个synchronizedXxx()方法用来获取线程安全的集合
    }
}