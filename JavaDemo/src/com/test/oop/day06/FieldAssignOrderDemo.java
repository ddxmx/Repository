package com.test.oop.day06;

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

    public User(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

public class FieldAssignOrderDemo {
    public static void main(String[] args) {
        User user = new User("李四", 16);
        // 初始化的值在构造器中被修改
        user.show(); // 姓名：李四，年龄：16

        user.setName("王五");
        user.setAge(19);
        // 构造器修改的值通过set方法被修改
        user.show(); // 姓名：王五，年龄：19
    }
}
