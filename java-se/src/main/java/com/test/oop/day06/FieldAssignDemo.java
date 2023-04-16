package com.test.oop.day06;

/**
 * 属性赋值的先后顺序
 * 1、属性初始化赋值（对象实例化完成前）
 * 2、构造器赋值（对象实例化完成前）
 * 3、set方法赋值（对象实例化完成后）
 */
class User {
    private String name = "张三";
    private int age = 18;

    public User(String name, int age) {
        System.out.println("构造器执行前：name=" + this.name + ",age=" + this.age);
        this.name = name;
        this.age = age;
        System.out.println("构造器执行后：name=" + this.name + ",age=" + this.age);
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
        /*
            构造器执行前：name=张三,age=18
            构造器执行后：name=李四,age=16
         */
        User user = new User("李四", 16);

        user.setName("王五");
        user.setAge(19);
        // set方法执行后：name=王五,age=19
        System.out.println("set方法执行后：name=" + user.getName() + ",age=" + user.getAge());
    }
}
