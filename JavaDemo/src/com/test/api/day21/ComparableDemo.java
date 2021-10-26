package com.test.api.day21;

import java.util.Arrays;

/**
 * Comparable比较器，要求类必须实现该接口
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    /**
     * 按年龄从大到小排序，年龄相同，按姓名字母正序排序
     */
    @Override
    public int compareTo(Person per) {
        if (this.age > per.age) {
            return -1;
        } else if (this.age < per.age) {
            return 1;
        } else {
            return this.name.compareTo(per.name);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Comparable比较器
 */
public class ComparableDemo {
    public static void main(String[] args) {
        Person per1 = new Person("jack", 22);
        Person per2 = new Person("helen", 24);
        Person per3 = new Person("tom", 22);
        Person per4 = new Person("jerry", 23);
        Person[] persons = new Person[]{per1, per2, per3, per4};
        // Arrays.sort()方法要求数组元素必须要实现Comparable接口，并根据覆写的compareTo()方法排序
        Arrays.sort(persons);
        // [Person{name='helen', age=24}, Person{name='jerry', age=23}, Person{name='jack', age=22}, Person{name='tom', age=22}]
        System.out.println(Arrays.toString(persons));
    }
}
