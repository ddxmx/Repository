package com.test.collection.day18.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector是List的同步实现类
 * Vector中对集合操作的方法都添加了synchronized关键字
 * Vector使用上和ArrayList无差别
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        vector.add("hello");
        vector.add("world");
        vector.add("java");

        System.out.println(vector); // [hello, world, java]

        // Vector对集合元素的遍历支持通过Enumeration接口实现类操作
        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
