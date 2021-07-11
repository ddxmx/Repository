package com.test.mybatis.pojo;

public class Person {
    private int id;
    private String username;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
