package com.test.day08;

/**
 * 面向对象和面向过程的区别：开发者从面向过程的执行者转化成了面向对象的指挥者
 * 面向对象的三大特征：封装、继承、多态
 * 一切皆对象（基本数据类型不是对象，不能够按照对象的方式使用，因此对于基本数据类型提供了包装类，用来统一类型的操作）
 * 类是对象的模版，对象是类的实例
 * 先有类，再有对象
 * 类的组成：属性（成员变量）、方法（成员方法）
 * <p>
 * 对象创建和使用内存解析：
 * 堆：存放对象的实例
 * 栈：存放局部变量
 * 方法区：类信息、 常量、 静态变量
 */
class Person {
    //成员变量
    String name;
    int age;
    boolean isMale;

    //成员方法
    public void eat() {
        System.out.println("eat...");
    }

    public void sleep() {
        System.out.println("sleep...");
    }

    public void talk(String language) {
        System.out.println("talk " + language + "...");
    }
}

public class ClassDemo {
    public static void main(String[] args) {
        //创建对象并实例化
        Person p1 = new Person();

        //分为两个步骤
        //Person p1 = null;
        //p1 = new Person();

        //设置属性
        p1.name = "张三";
        p1.age = 20;
        p1.isMale = true;
        System.out.printf("姓名：%s，年龄：%d，是否男性：%s\n", p1.name, p1.age, p1.isMale); // 姓名：张三，年龄：20，是否男性：true

        //调用方法
        p1.eat(); //eat...
        p1.sleep(); //sleep...
        p1.talk("Chinese"); //talk Chinese...

        //定义一个新的对象
        Person p2 = new Person();
        System.out.println(p2.name); // String类型的默认值是null

        //类的引用传递
        Person p3 = p1; //p1和p3指向同一块堆内存空间
        System.out.println(p3.name); // 张三
        p3.age = 22; //修改指向的堆内存空间的属性，当前p1和p3指向同一块堆内容空间
        System.out.println(p1.age); // 22
    }
}
