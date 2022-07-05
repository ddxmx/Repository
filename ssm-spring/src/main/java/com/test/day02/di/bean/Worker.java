package com.test.day02.di.bean;

/**
 * 构造器注入不依赖set方法
 */
public class Worker {
    private String name;
    private int age;
    private Car car;

    public Worker(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
