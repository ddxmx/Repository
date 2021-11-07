package com.test.collection.day23;

import java.util.*;

/**
 * TreeSet判断元素是否相等，是按照compareTo方法进行判断
 * TreeSet底层是TreeMap，采用红黑树结构
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet();
        set.add(15);
        set.add(32);
        set.add(-28);
        set.add(45);
        set.add(9);
        printSet(set); // [-28,9,15,32,45]

        System.out.println("***********************");
        TreeSet<Person> set2 = new TreeSet();
        // TreeSet元素必须要实现java.utils.comparable接口
        set2.add(new Person("Jack", 22));
        set2.add(new Person("Helen", 20));
        set2.add(new Person("Tom", 24));
        set2.add(new Person("Jerry", 21));
        set2.add(new Person("Bob", 22));
        /*
            Person{name='Tom', age=24}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Jerry', age=21}
            Person{name='Helen', age=20}
         */
        printSet(set2);

        System.out.println("***********************");
        Comparator comparator = (o1, o2) -> {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;
            if (p1.getAge() < p2.getAge()) {
                return -1;
            } else if (p1.getAge() > p2.getAge()) {
                return 1;
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        };

        TreeSet set3 = new TreeSet(comparator);
        set3.addAll(set2);
        /*
            Person{name='Helen', age=20}
            Person{name='Jerry', age=21}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Tom', age=24}
         */
        printSet(set3);
    }

    public static void printSet(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}