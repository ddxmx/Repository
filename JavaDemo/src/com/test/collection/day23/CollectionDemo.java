package com.test.collection.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection接口是List、Set的父接口
 */
public class CollectionDemo {
    public static void main(String[] args) {
        // 使用子类进行接口实例化
        Collection<String> coll = new ArrayList<>();

        // 添加元素，类型必须是String类型
        coll.add("A");
        coll.add("B");
        coll.add("123");

        // 元素的个数
        System.out.println(coll.size()); // 3

        // 将其他集合元素添加到当前集合末尾
        coll.addAll(Arrays.asList("hello", "world"));
        System.out.println(coll); // [A, B, 123, hello, world]

        // 迭代输出集合元素，Collection接口继承Iterable接口
        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "、"); // A、B、123、hello、world、
        }
        System.out.println();

        // 判断集合是否包含指定元素
        System.out.println(coll.contains("B")); // true
        System.out.println(coll.contains("C")); // false

        // 判断集合是否包含子集合
        System.out.println(coll.containsAll(Arrays.asList("hello", "world"))); // true
        System.out.println(coll.containsAll(Arrays.asList("B", "C"))); // false

        // 删除集合中的元素
        coll.remove("123");
        System.out.println(coll); // [A, B, hello, world]

        // 删除在子集合中存在的所有元素
        coll.removeAll(Arrays.asList("B", "C", "hello"));
        System.out.println(coll.toString()); // [A, world]

        // 获取集合和子集合的交集
        coll.retainAll(Arrays.asList("hello", "world"));
        System.out.println(coll.toString()); // [world]

        // 判断集合元素相等
        System.out.println(coll.equals(Arrays.asList("world"))); // true

        // 清空集合元素
        coll.clear();

        // 判断集合是否为空
        System.out.println(coll.isEmpty()); // true
    }
}
