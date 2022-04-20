package com.test.oop.day05;

/**
 * 面向对象和面向过程的区别：开发者从面向过程的执行者转变成了面向对象的指挥者
 * 面向对象的三大特征：封装、继承、多态
 * 一切皆对象（基本数据类型不是对象，不能够按照对象的方式使用，因此对于基本数据类型提供了包装类，用来统一类型的操作）
 * 类是对象的模版，对象是类的实例
 * 先有类，再有对象
 * 类的组成：属性（成员变量）、方法（成员方法）
 * 对象创建和使用内存解析：
 * |-栈：存放局部变量
 * |-堆：存放对象实例
 * |-方法区：类信息、 常量、 静态变量
 */
class Person {
    // 成员变量
    String name;
    int age;

    // 成员方法
    public void eat() {
        System.out.println("Person.eat");
    }

    public void sleep() {
        System.out.println("Person.sleep");
    }

    public void talk(String language) {
        System.out.println("Person.talk " + language);
    }
}

public class ClassDemo {
    public static void main(String[] args) {
        // 方式一：创建对象并实例化
        Person p1 = new Person();

        // 方式二：分为两个步骤，分别进行声明和实例化
        Person per = null;
        per = new Person();

        // 设置属性
        p1.name = "张三";
        p1.age = 20;
        System.out.println("姓名：" + p1.name + "，年龄：" + p1.age); // 姓名：张三，年龄：20

        // 调用方法
        p1.eat(); // Person.eat
        p1.sleep(); // Person.sleep
        p1.talk("Chinese"); // Person.talk Chinese

        // 创建一个新的对象
        Person p2 = new Person();
        // 属性未赋值，使用对应数据类型默认值
        // String是引用数据类型，默认值是null
        System.out.println(p2.name); // null

        // 类的引用传递
        // p1和p3指向同一块堆内存空间
        Person p3 = p1;
        System.out.println(p3.name); // 张三
        // 修改指向的堆内存空间的属性，当前p1和p3指向同一块堆内存空间
        p3.age = 22;
        System.out.println(p1.age); // 22
    }
}
