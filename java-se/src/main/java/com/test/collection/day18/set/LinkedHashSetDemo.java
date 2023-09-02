package com.test.collection.day18.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet可以按照添加时的顺序遍历元素
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<Object> set = new LinkedHashSet<>();

        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(123);

        /*
            456
            123
            AA
            CC
            Person{name='Tom', age=12}
         */
        Iterator<Object> linkedIterator = set.iterator();
        while (linkedIterator.hasNext()) {
            System.out.println(linkedIterator.next()); // [456, 123, AA, CC, Person{name='Tom', age=12}]
        }
    }
}
