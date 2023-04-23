package com.test.oop.day09.common;

import java.util.Objects;

/**
 * Object其他方法的使用
 */
class Customer implements Cloneable {
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
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
     * （1）覆写clone方法的类必须要实现java.lang.Cloneable接口，该接口中无任何抽象方法，只是表示一种能力
     * （2）为什么Object类中的clone()方法是使用protected修饰，而不是使用public修饰？
     * |- Object类中的clone方法是一个浅拷贝的实现，无法实现深拷贝
     * |- 业务如果想使用clone方法，必须在子类覆写该方法，明确拷贝的方式
     */
    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }
}

public class ObjectMethodDemo {
    public static void main(String[] args) throws Exception {
        Customer c1 = new Customer("Tom", 12);
        Customer c2 = c1.clone();
        System.out.println(c1 == c2); // false
        // 需要覆写equals方法
        System.out.println(c1.equals(c2)); // true
        // 由于是浅拷贝，所以对象中的属性还是使用的同一个
        System.out.println(c1.getName() == c2.getName()); // true

        c1.setName("Jack");
        System.out.println(c1.getName()); // Jack
        // String的不可变特性，c1的name属性修改指向，指向其他的堆内存地址
        System.out.println(c2.getName()); // Tom
    }
}
