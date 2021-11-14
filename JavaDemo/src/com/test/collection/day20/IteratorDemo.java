package com.test.collection.day20;

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

        //  在集合元素遍历时，删除元素需要使用iterator的remove方法，而不是list的remove方法
        //  Collection接口也是Iterable的子接口，主要为了实现iterator()方法
        //  Iterator遍历Collection时，是fail-fast机制的。
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            // remove前必须要调用next()
            String next = iterator.next();
            if ("world".equals(next)) {
                iterator.remove();
            }
        }

        System.out.println(list); //  [hello, hello, java]

        System.out.println("**********************************");
        int[] arr = new int[]{1, 2, 3};
        //  增强for循环对于基本数据类型和String类型无法修改其数组或集合中的元素值
        for (int value : arr) {
            value *= 2;
        }
        System.out.println(Arrays.toString(arr)); //  [1, 2, 3]

        Person[] pers = new Person[]{new Person("tom", 20),
                new Person("jerry", 16), new Person("jack", 18)};
        for (Person per : pers) {
            // 引用数据类型直接操作的是数组或集合中的元素
            per.setAge(per.getAge() + 1);
        }
        // [Person{name='tom', age=21}, Person{name='jerry', age=17}, Person{name='jack', age=19}]
        System.out.println(Arrays.toString(pers));
    }
}
