package com.test.collection.day18.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet判断元素是否相等，是按照compareTo方法进行判断
 * TreeSet底层是TreeMap，采用红黑树结构
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet();
        treeSet.add(15);
        treeSet.add(32);
        treeSet.add(-28);
        treeSet.add(45);
        treeSet.add(9);
        print(treeSet); // [-28,9,15,32,45]

        System.out.println("=============================元素实现Comparable接口用于排序=============================");
        Set<Person> comparableSet = new TreeSet();
        // TreeSet元素必须要实现java.utils.comparable接口
        comparableSet.add(new Person("Jack", 22));
        comparableSet.add(new Person("Helen", 20));
        comparableSet.add(new Person("Tom", 24));
        comparableSet.add(new Person("Jerry", 21));
        comparableSet.add(new Person("Bob", 22));
        /*
            Person{name='Tom', age=24}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Jerry', age=21}
            Person{name='Helen', age=20}
         */
        print(comparableSet);

        System.out.println("=============================使用传入的Comparator实现排序=============================");
        Set<Person> comparatorSet = new TreeSet<>((o1, o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        comparatorSet.add(new Person("Jack", 22));
        comparatorSet.add(new Person("Helen", 20));
        comparatorSet.add(new Person("Tom", 24));
        comparatorSet.add(new Person("Jerry", 21));
        comparatorSet.add(new Person("Bob", 22));

        /*
            Person{name='Helen', age=20}
            Person{name='Jerry', age=21}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Tom', age=24}
         */
        print(comparatorSet);
    }

    public static void print(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}