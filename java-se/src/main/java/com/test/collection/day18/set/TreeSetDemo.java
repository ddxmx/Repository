package com.test.collection.day18.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return -1;
        } else if (this.age < o.age) {
            return 1;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}

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
        Set<Person> perTreeSet = new TreeSet();
        // TreeSet元素必须要实现java.utils.comparable接口
        perTreeSet.add(new Person("Jack", 22));
        perTreeSet.add(new Person("Helen", 20));
        perTreeSet.add(new Person("Tom", 24));
        perTreeSet.add(new Person("Jerry", 21));
        perTreeSet.add(new Person("Bob", 22));
        /*
            Person{name='Tom', age=24}
            Person{name='Bob', age=22}
            Person{name='Jack', age=22}
            Person{name='Jerry', age=21}
            Person{name='Helen', age=20}
         */
        print(perTreeSet);

        System.out.println("=============================使用传入的Comparator实现排序=============================");
        Set comparatorSet = new TreeSet((o1, o2) -> {
            Person p1 = (Person) o1;
            Person p2 = (Person) o2;
            if (p1.getAge() < p2.getAge()) {
                return -1;
            } else if (p1.getAge() > p2.getAge()) {
                return 1;
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        });
        comparatorSet.addAll(perTreeSet);
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