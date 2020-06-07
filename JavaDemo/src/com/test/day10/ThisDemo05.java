package com.test.day10;

import java.util.Objects;

/**
 * this.属性
 * this.方法()
 * this表示当前对象
 * this()调用构造方法，需要预留出口，不能造成递归，必须放在构造方法的首行
 */
class Person05 {
    private String name;
    private int age;

    public Person05() {
        this("无名氏", 18);
    }

    public Person05(String name) {
        this(name, 18);
    }

    public Person05(String name, int age) {
//        this(); 编译失败，构造方法的递归调用
        // this调用属性
        this.name = name;
        // this调用方法
        this.setAge(age);
        System.out.println("一个person对象产生");
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj) {
            return false;
        }

        // this表示当前对象
        if (this.getClass() == obj.getClass()) {
            Person05 per = (Person05) obj;
            return this.getName().equals(per.getName()) && this.getAge() == per.getAge();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class ThisDemo05 {
    public static void main(String[] args) {
        Person05 per = new Person05("tom", 20);
        Person05 per2 = new Person05("tom", 20);
        Person05 per3 = new Person05("tom", 21);
        System.out.println(per.equals(per2)); // true
        System.out.println(per.equals(per3)); // false
    }
}
