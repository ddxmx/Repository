package com.test.day08;

/**
 * 方法中可以调用属性和方法
 * 方法不能嵌套定义
 */
class Person04 {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public String getInfo() {
        return "姓名：" + getName() + "，年龄：" + age;
    }
}

public class ClassDemo02 {
    public static void main(String[] args) {
        Person04 per = new Person04();
        per.name = "张三";
        per.age = 20;
        System.out.println(per.getInfo()); //姓名：张三，年龄：20
    }
}
