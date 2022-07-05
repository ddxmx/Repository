package com.test.collection.day18.set;

import com.test.collection.day18.Person;

import java.util.Comparator;
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
        printSet(treeSet); // [-28,9,15,32,45]

        System.out.println("***************元素实现Comparable接口用于排序***************");
        Set<Person> personTreeSet = new TreeSet();
        // TreeSet元素必须要实现java.utils.comparable接口
        personTreeSet.add(new Person("Jack", 22));
        personTreeSet.add(new Person("Helen", 20));
        personTreeSet.add(new Person("Tom", 24));
        personTreeSet.add(new Person("Jerry", 21));
        personTreeSet.add(new Person("Bob", 22));
        /*
            Person{name='Tom', age=24}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Jerry', age=21}
            Person{name='Helen', age=20}
         */
        printSet(personTreeSet);

        System.out.println("***************使用传入的Comparator实现排序***************");
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

        Set personSet = new TreeSet(comparator);
        personSet.addAll(personTreeSet);
        /*
            Person{name='Helen', age=20}
            Person{name='Jerry', age=21}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Tom', age=24}
         */
        printSet(personSet);
    }

    public static void printSet(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}