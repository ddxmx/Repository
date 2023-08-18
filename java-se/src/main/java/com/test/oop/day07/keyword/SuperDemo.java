package com.test.oop.day07.keyword;

class Person {
    int id = 1001;
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "姓名：" + name + "，年龄：" + age;
    }
}

/**
 * 1、可以在子类的方法或构造器中使用super.属性或super.方法名()的方式显式调用父类的成员
 * 2、可以在子类的构造器中使用super(形参列表)的方式显示调用父类的构造器
 * super(形参列表)，必须声明在子类构造器的首行
 * 3、this和super的区别:
 * （1）this访问本类中的属性，如果本类没有此属性则从父类中继续查找，super直接访问父类中的属性
 * （2）this访问本类中的方法，如果本类没有此方法则从父类中继续查找，super直接访问父类中的方法
 * （3）this调用本类构造器，必须放在构造器的首行，super调用父类构造器，必须放在子类构造器的首行
 * （4）this表示当前对象，可以独立使用，super没有此特性
 */
class Student extends Person {
    // 父子类中同名属性不存在覆写的概念，调用时由对象的声明类型决定
    int id = 1002;
    double score;

    public Student() {
        // 子类的构造器如果没有显式使用this(形参列表)或super(形参列表)，默认会调用父类的无参构造
        // 此时，如果父类中不存在无参构造，则编译错误
        super();
    }

    public Student(String name, int age, double score) {
        // 在子类构造器中调用父类两个参数的构造器
        super(name, age);
        this.score = score;
    }

    public void printId() {
        // 在子类中使用super调用父类的属性
        System.out.println(super.id);
        System.out.println(this.id);
    }

    /**
     * 覆写父类的getInfo()方法
     */
    @Override
    public String getInfo() {
        // 在子类中使用super调用父类方法
        return super.getInfo() + "，成绩：" + score;
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        Student stu = new Student("张三", 20, 94.5);
        /*
            1001
            1002
         */
        stu.printId();
        System.out.println(stu.getInfo()); // 姓名：张三，年龄：20，成绩：94.5

        Person per = stu;
        // 父子类同名的属性，调用时取决于声明的类型
        System.out.println(per.id); // 1001
        System.out.println(stu.id); // 1002
    }
}
