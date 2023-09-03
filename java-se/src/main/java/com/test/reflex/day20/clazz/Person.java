package com.test.reflex.day20.clazz;

import java.io.IOException;
import java.io.Serializable;

abstract class Animal implements Cloneable {
    public abstract void eat();
}

@Deprecated
public class Person extends Animal implements Serializable {
    private String name;
    private int age;
    public static String city = "北京";

    public Person() {
        System.out.println("Person() constructor");
    }

    private Person(String name) {
        System.out.println("Person(String name) constructor");
        this.name = name;
    }

    public Person(String name, int age) {
        System.out.println("Person(String name, int age) constructor");
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

    public void show() {
        show("中国");
    }

    public void show(String nation) {
        System.out.println("Person.show：" + nation);
    }

    private void test() throws IOException {
        System.out.println("Person.test");
    }

    @Override
    public void eat() {
        System.out.println("Person eat");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
