package com.test.day10;

/**
 * 构造方法是实例化的最后一步，调用构造方法生成对象后，才可以调用类中的成员方法
 * <p>
 * 如果类没有明确定义构造方法，则系统会默认生成一个无参的、什么都不做的构造方法，权限和类的权限一致
 * 如果明确的定义构造方法，则默认构造方法将不会再自动生成
 * 构造方法可以重载
 */
class Person03 {
    private String name;
    private int age;

    public Person03() {
    }

    public Person03(String _name) {
        name = _name;
    }

    public Person03(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public void print() {
        System.out.println("name=" + name + "，age=" + age);
    }
}

public class ConstructorDemo03 {
    public static void main(String[] args) {
        // 类型 引用变量 = new 构造方法;
        Person03 per = new Person03("tom", 23);
        per.print(); // name=tom，age=23

        Person03 per2 = new Person03("jack");
        per2.print(); // name=jack，age=0
    }
}
