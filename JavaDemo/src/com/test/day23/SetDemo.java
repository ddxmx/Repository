package com.test.day23;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set接口中元素无序、不可重复
 * HashSet：Set接口常用实现类，线程不安全，可以存储null，通过HashMap实现
 * LinkedHashSet：HashSet子类，可以按照添加的顺序遍历，逻辑上有序，存储上无序
 * TreeSet：可以对元素进行排序，元素类型必须要重写hashcode和equals方法，通过TreeMap实现
 */
public class SetDemo {
    public static void main(String[] args) {
        /*
            无序性，不等于随机性，存储的数据在底层数组中不是按照数组索引顺序添加，而是按照数据的hashCode()方法添加
            不可重复性：需要元素覆写equals方法，来判断元素内容是否相同
            元素重复是根据hashCode和equals方法进行判断，使用数据结构数组+链表的方法存储
            hashcode决定存放位置，equals进一步判断是否为同一个元素，相同则只会存储一个，不同则添加到同一个位置的链表上
         */
        HashSet<Object> set = new HashSet<>();
        fun(set);
        set.add(new Person("Tom", 12));
        System.out.println(set); //[AA, CC, 456, 123, Person{name='Tom', age=12}]

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--------------------------------");
        LinkedHashSet<Object> set2 = new LinkedHashSet<>();
        fun(set2);
        //遍历的顺序就是添加的顺序
        Iterator<Object> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next()); //[456, 123, AA, CC, Person{name='Tom', age=12}]
        }
    }

    public static void fun(Set<Object> set) {
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(123);
    }
}
