package com.test.day09;

class Person01 {
    String name = "jack";
    int age = 24;
}

class PersonFactory {
    public static void tell(Person01 per) {
        System.out.println("name=" + per.name + ",age=" + per.age);
    }
}

/**
 * 匿名对象，没有栈空间指向，只能使用一次就成为垃圾空间
 * 和抽象类、接口使用比较常见
 */
public class AnonymousObjectDemo01 {
    public static void main(String[] args) {
        PersonFactory.tell(new Person01());
    }
}
