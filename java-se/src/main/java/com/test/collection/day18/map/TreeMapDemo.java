package com.test.collection.day18.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;

    /**
     * 按年龄从大到小排序，相同年龄按照名字从小到大排序
     */
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
 * TreeMap排序的元素必须要实现Comparable接口，否则将出现java.lang.ClassCastException
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        System.out.println("=========================元素实现Comparable接口进行排序=========================");
        TreeMap<Person, Integer> comparableMap = new TreeMap<>();

        comparableMap.put(new Person("Jack", 22), 10);
        comparableMap.put(new Person("Helen", 20), 20);
        comparableMap.put(new Person("Tom", 24), 25);
        comparableMap.put(new Person("Jerry", 21), 15);
        comparableMap.put(new Person("Bob", 22), 30);

        /*
            Person{name='Tom', age=24}->25
            Person{name='Bob', age=22}->30
            Person{name='Jack', age=22}->10
            Person{name='Jerry', age=21}->15
            Person{name='Helen', age=20}->20
         */
        print(comparableMap);

        System.out.println("=========================指定Comparator接口进行排序=========================");
        TreeMap<Person, Integer> comparatorMap = new TreeMap<>((o1, o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        comparatorMap.put(new Person("Jack", 22), 10);
        comparatorMap.put(new Person("Helen", 20), 20);
        comparatorMap.put(new Person("Tom", 24), 25);
        comparatorMap.put(new Person("Jerry", 21), 15);
        comparatorMap.put(new Person("Bob", 22), 30);

        /*
            Person(name=Helen, age=20)->20
            Person(name=Jerry, age=21)->15
            Person(name=Bob, age=22)->30
            Person(name=Jack, age=22)->10
            Person(name=Tom, age=24)->25
         */
        print(comparatorMap);
    }

    public static void print(Map<Person, Integer> map) {
        Set<Map.Entry<Person, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Person, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}