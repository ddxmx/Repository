package com.test.day08;

/**
 * 面向对象三大特效：封装、继承、多态，一切皆对象
 * 类是对象的模版，对象是类的实例
 * 先有类，再有对象
 * 类的组成：属性（成员变量）、方法（成员方法）
 */
class Person01 {
    String name;
    int age;
    boolean isMale;

    public void eat() {
        System.out.println("eat...");
    }

    public void sleep() {
        System.out.println("sleep...");
    }

    public void talk(String language) {
        System.out.println("talk " + language);
    }
}

public class ClassDemo01 {
    public static void main(String[] args) {
        Person01 p1 = new Person01(); //创建对象并实例化
        //设置属性
        p1.name = "张三";
        p1.age = 20;
        p1.isMale = true;
        System.out.printf("姓名：%s，年龄：%s，是否男性：%s\n", p1.name, p1.age, p1.isMale); // 姓名：张三，年龄：20，是否男性：true
        //调用方法
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");

        Person01 p2 = new Person01();
        System.out.println(p2.name); // null

        Person01 p3 = p1; //p1和p3指向同一块堆内存空间
        System.out.println(p3.name); // 张三
        p3.age = 22;
        System.out.println(p1.age); // 22
    }
}
