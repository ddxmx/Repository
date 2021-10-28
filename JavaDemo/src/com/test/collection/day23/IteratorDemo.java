package com.test.collection.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 集合的遍历操作
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("java");

        //在集合元素遍历时，删除元素需要使用iterator的remove方法，而不是list的remove方法
        //Collection接口也是Iterable的子接口，主要为了实现iterator()方法
        //Iterator遍历Collection时，是fail-fast机制的。
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("world".equals(next)) {
                iterator.remove();
            }
        }

        System.out.println(list); //[hello, hello, java]

        System.out.println("**********************************");
        /*
            hello
            hello
            java
         */
        for (String str : list) {
            System.out.println(str);
        }

        int[] arr = new int[]{1, 2, 3};
        //增强for循环对于基本数据类型和String类型无法修改其数组或集合中的元素值
        for (int value : arr) {
            value *= 2;
        }
        System.out.println(Arrays.toString(arr)); //[1, 2, 3]
    }
}
