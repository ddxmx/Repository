package com.test.collection.day18.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合遍历中删除元素
 */
public class IteratorRemoveDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("java");

        //  在集合元素遍历时，删除元素需要使用iterator的remove方法，而不是list的remove方法
        //  Collection接口也是Iterable的子接口，主要为了实现iterator()方法
        //  Iterator遍历Collection时，是fail-fast机制的
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // remove前必须要调用next()
            String next = iterator.next();
            if ("world".equals(next)) {
                iterator.remove();
            }
        }

        System.out.println(list); //  [hello, hello, java]
    }
}
