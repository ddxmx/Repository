package com.test.ioc;

public class User {
    private String name;
    private int age;

    /**
     * 必须存在无参构造，Spring初始化bean以来此构造
     */
    public User() {
        System.out.println("实例化一个User对象");
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name = " + name + ",age = " + age);
    }
}
