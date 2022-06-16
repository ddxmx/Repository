package com.test.reflex.day20;

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
        System.out.println("Person() constructor invoke");
    }

    private Person(String name) {
        System.out.println("Person(String name) constructor invoke");
        this.name = name;
    }

    public Person(String name, int age) {
        System.out.println("Person(String name, int age) constructor invoke");
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
        System.out.println("我是一个" + nation + "人");
    }

    private void test() throws IOException {
        System.out.println("hello world!");
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
