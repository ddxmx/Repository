package com.test.oop.day07;

/**
 * 属性赋值的先后顺序
 * 1、属性初始化赋值
 * 2、构造器赋值
 * 3、set方法赋值
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class FieldAssignDemo {
    public static void main(String[] args) {
        User user1 = new User();
        System.out.println(user1); // User{name='张三', age=18}

        User user2 = new User("Tom", 20);
        System.out.println(user2); // User{name='Tom', age=20}
    }
}
