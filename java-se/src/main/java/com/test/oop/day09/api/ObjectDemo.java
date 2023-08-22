package com.test.oop.day09.api;

import java.util.Objects;

class Person implements Cloneable {
    private String name;
    private int age;

    public Person() {
    }

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
     * protected native Object clone() throws CloneNotSupportedException;
     * 1、覆写clone方法的类必须要实现java.lang.Cloneable接口，该接口中无任何抽象方法，只是表示一种能力
     * 2、为什么Object类中的clone()方法是使用protected修饰，而不是使用public修饰？
     * （1）Object类中的clone方法是一个浅拷贝的实现，无法实现深拷贝
     * （2）业务如果想使用clone方法，必须在子类覆写该方法，明确拷贝的实现
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    /**
     * hashCode的作用是获取哈希码（int整数），也称为散列码
     * 1、对于使用hash方式存储的结构，为了提升效率，需要依赖hashCode()方法确定对象在哈希表中的索引位置，再通过equals()方法判断是否相等
     * 2、hashCode方法实现的约束
     * （1）重写equals()时必须重写hashCode()方法
     * （2）两个对象hashCode值相等，对象不一定相等（hash碰撞）
     * （3）两个对象hashCode值不相等，对象就不相等
     * （4）两个对象相等，则hashCode值也相等
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * 覆写equals方法
     * java.lang.Object类中的equals方法默认实现使用 == 进行比较，比较的是内存地址
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {
            Person per = (Person) obj;
            return Objects.equals(this.name, per.name) &&
                    this.age == per.age;
        }

        return false;
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
 * Object类是所有类的顶层父类
 * 如果一个类没有显式使用extends继承其他类，则默认继承java.lang.Object类
 * Object类可以接收所有的引用数据类型，包括数组和接口
 */
public class ObjectDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person per1 = new Person("张三", 20);
        Person per2 = new Person("张三", 20);
        Person per3 = new Person("张三", 22);

        // equals方法
        System.out.println(per1 == per2); // false
        System.out.println(per1.equals(per2)); // true
        System.out.println(per1.equals(per3)); // false
        System.out.println(per1.equals(per1)); // true
        System.out.println(per1.equals(null)); // false

        // clone方法
        Person per4 = per1.clone();
        System.out.println(per1 == per4); // false
        System.out.println(per1.equals(per4)); // true
        // 由于是浅拷贝，所以对象中的属性还是使用的同一个
        System.out.println(per1.getName() == per4.getName()); // true

        // 单独使用对象或与字符串拼接时，默认会调用对象的toString()方法
        System.out.println(per1); // Person{name='张三', age=20}
        System.out.println("用户信息：" + per1); // 用户信息：Person{name='张三', age=20}
    }
}
