package com.test.collection.day18.map;

import com.test.collection.day18.Person;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap排序的元素必须要实现Comparable接口
 * 否则将出现java.lang.ClassCastException
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Person, Integer> map = new TreeMap<>();
        map.put(new Person("Jack", 22), 10);
        map.put(new Person("Helen", 20), 20);
        map.put(new Person("Tom", 24), 25);
        map.put(new Person("Jerry", 21), 15);
        map.put(new Person("Bob", 22), 30);

        /*
            Person{name='Tom', age=24}->25
            Person{name='Bob', age=22}->30
            Person{name='Jack', age=22}->10
            Person{name='Jerry', age=21}->15
            Person{name='Helen', age=20}->20
         */
        Set<Map.Entry<Person, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Person, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}