package com.test.day10;

/**
 * 属性赋值的先后顺序
 * 1、属性的赋值
 * 2、构造器的赋值
 * 3、set方法的赋值
 */
class User {
    private String name = "张三";
    private int age = 18;

    public User() {
    }

    public User(String name, int age) {
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
}

public class FieldAssignDemo {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User("Tom", 20);
    }
}
