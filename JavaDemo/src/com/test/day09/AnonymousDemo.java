package com.test.day09;

class Person {
    public void eat() {
        System.out.println("吃饭...");
    }

    public void sleep() {
        System.out.println("睡觉...");
    }
}

/**
 * 匿名对象的使用
 * 匿名对象只能使用一次，一般用于调用一次方法或者用于参数传递
 */
public class AnonymousDemo {
    public static void main(String[] args) {
        //有名对象
        Person per = new Person();
        per.eat();

        //匿名对象
        new Person().eat();
        new Person().eat(); //和上面的匿名对象不是同一个，每一个new都会创建一个新对象

        //调用方法时，参数可以使用匿名对象传递
        action(new Person());
    }

    /**
     * 方法参数的类型是自定义类
     *
     * @param person
     */
    public static void action(Person person) {
        person.eat();
        person.sleep();
    }
}
