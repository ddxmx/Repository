package com.test.oop.day05.object;

/**
 * 匿名对象
 * 只能使用一次，一般用于只需要调用一次方法或者用于参数传递
 */
public class ObjectAnonDemo01 {
    public static void main(String[] args) {
        // 对象有名称
        Person per = new Person();
        per.eat(); // Person.eat

        // 匿名对象
        new Person().eat(); // Person.eat
        // 和上面的匿名对象不是同一个，每次new都会创建一个新对象
        new Person().eat(); // Person.eat
        System.out.println(new Person() == new Person()); // false

        // 调用方法时，参数可以使用匿名对象传递
        action(new Person());
    }

    /**
     * 方法参数的类型是引用数据类型
     */
    public static void action(Person per) {
        per.eat(); // Person.eat
    }
}

class Person {
    public void eat() {
        System.out.println("Person.eat");
    }
}
