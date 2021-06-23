package com.test.ioc;

public class Person {
    private String name;
    private int age;

    /**
     * 必须存在无参构造，Spring初始化bean以来此构造
     */
    public Person() {
        System.out.println("实例化一个User对象");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name = " + name + ",age = " + age);
    }
}
