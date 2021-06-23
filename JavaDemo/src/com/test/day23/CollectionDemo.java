package com.test.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection接口是List、Set的父接口
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //使用子类进行接口实例化
        Collection<String> collection = new ArrayList<>();

        //添加元素
        collection.add("A");
        collection.add("B");
        collection.add("123");

        //元素的个数
        System.out.println(collection.size()); //3

        //将其他集合元素添加到当前集合末尾
        collection.addAll(Arrays.asList("hello", "world"));
        System.out.println(collection.toString()); //[A, B, 123, hello, world]

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "、"); //A、B、123、hello、world、
        }
        System.out.println();

        System.out.println(collection.contains("B")); //true
        System.out.println(collection.contains("C")); //false

        System.out.println(collection.containsAll(Arrays.asList("hello", "world"))); //true
        System.out.println(collection.containsAll(Arrays.asList("B", "C"))); //false

        //删除集合中的元素
        collection.remove("123");
        System.out.println(collection.toString()); //[A, B, hello, world]

        collection.removeAll(Arrays.asList("B", "C", "hello"));
        System.out.println(collection.toString()); //[A, world]

        //获取集合的交集
        collection.retainAll(Arrays.asList("hello", "world"));
        System.out.println(collection.toString()); //[world]

        System.out.println(collection.equals(Arrays.asList("world"))); //true

        //清空集合元素
        collection.clear();

        System.out.println(collection.isEmpty()); //true

        System.out.println(collection.size()); //0
    }
}
