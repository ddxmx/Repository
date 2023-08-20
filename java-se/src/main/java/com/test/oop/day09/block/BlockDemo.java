package com.test.oop.day09.block;

/**
 * 1、代码块，用来初始化类或对象，分为静态代码块和非静态代码块
 * 静态代码块：随着类的加载而执行，只执行一次
 * 非静态代码块：随着对象的创建而执行，每次创建对象都会执行
 * 2、主类中的静态块优先于主方法执行
 * 3、类中结构执行的先后顺序：
 * （1）父类静态属性/父类静态代码块
 * （2）子类静态属性/子类静态代码块
 * （3）父类实例属性/父类普通代码块
 * （4）父类构造方法
 * （5）子类实例属性/子类普通代码块
 * （6）子类构造方法
 */
class Person {
    // 静态代码块
    static {
        System.out.println("Person static block");
    }

    // 非静态代码块
    {
        System.out.println("Person normal block");
    }

    public Person() {
        System.out.println("Person constructor");
    }
}

class Student extends Person {
    // 静态代码块
    static {
        System.out.println("Student static block");
    }

    // 非静态代码块
    {
        System.out.println("Student normal block");
    }

    public Student() {
        System.out.println("Student constructor");
    }
}

public class BlockDemo {
    // 主类中的静态代码块
    static {
        System.out.println("main static block");
    }

    // 主类中的非静态代码块
    {
        System.out.println("main normal block");
    }

    public static void main(String[] args) {
        /*
            main static block
            main method
            main normal block
         */
        new BlockDemo();

        /*
            Person static block
            Student static block
            Person normal block
            Person constructor
            Student normal block
            Student constructor

            Person normal block
            Person constructor
            Student normal block
            Student constructor
         */
        new Student();
        new Student();
    }
}
