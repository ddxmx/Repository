package com.test.collection.day20;

import java.util.*;

/**
 * TreeMap排序的元素必须要实现Comparable接口
 * 否则将出现java.lang.ClassCastException
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<User, Integer> map = new TreeMap<>();
        map.put(new User("Jack", 22), 10);
        map.put(new User("Helen", 20), 20);
        map.put(new User("Tom", 24), 25);
        map.put(new User("Jerry", 21), 15);
        map.put(new User("Bob", 22), 30);

        /*
            User{name='Tom', age=24}->25
            User{name='Bob', age=22}->30
            User{name='Jack', age=22}->10
            User{name='Jerry', age=21}->15
            User{name='Helen', age=20}->20
         */
        Set<Map.Entry<User, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<User, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<User, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}

class User implements Comparable<User> {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(User o) {
        if (this.age > o.age) {
            return -1;
        } else if (this.age < o.age) {
            return 1;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}