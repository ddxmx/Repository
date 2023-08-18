package com.test.oop.day07.extend;

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void eat() {
        System.out.println("Person.eat");
    }

    public void sleep() {
        System.out.println("Person.sleep");
    }
}

/**
 * 1、继承为了代码复用，子类和父类有公共的属性和方法，子类无需重复定义，直接继承父类即可。继承也是实现多态的前提
 * 子类继承父类，获取父类中所有的属性和方法，private属性和方法也会被继承，只是无法直接访问
 * 2、一个父类可以被多个子类继承，但是一个子类只能直接继承一个父类，类具有单继承的限制，但是允许多层继承，A继承B，B继承C
 * 父类也叫做基类、超类，子类也叫做派生类
 * 3、继承是is a的关系，如：苹果是水果，继承的两个类在实际设计时，应该存在一定的关联，属于同一类概念
 * 4、一个类如果没有明确的继承另外一个类，则默认继承java.lang.Object类，所有的类都直接或间接继承Object类
 */
class Student extends Person {
    // Student类扩展了Person类的功能，新增了属性
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Student类中扩展了父类的功能，新增了方法
     */
    public void study() {
        System.out.println("Student.study");
    }
}

public class ClassExtendsDemo {
    public static void main(String[] args) {
        Student student = new Student("张三", 12, 90.5);
        // 调用从父类继承的方法获取父类属性
        System.out.println(student.getName()); // 张三
        // 调用子类扩展的方法获取子类属性
        System.out.println(student.getScore()); // 90.5
        // 调用从父类继承的方法
        student.eat(); // Person.eat
        // 调用子类扩展的方法
        student.study(); // Student.study
    }
}
