package com.test.oop.day08;

/**
 * abstract可以用来修饰抽象类和抽象方法
 * 抽象类不能直接实例化，实例化时需要依赖子类
 * 抽象类也存在构造器，子类实例化需要依赖抽象父类的构造器
 * 抽象方法只有方法声明，没有方法体
 * 包含抽象方法的类，需要声明为抽象类。但抽象类不一定包含抽象方法
 * 抽象类的子类需要覆写抽象类中所有的抽象方法，如果子类不覆写，子类需要继续使用abstract修饰
 */
abstract class Person {
    private String name;
    private int age;

    /**
     * 抽象类也存在构造器
     */
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

    /**
     * 抽象方法，只有方法声明，没有方法实现
     */
    public abstract void eat();

    /**
     * 普通方法
     */
    public void sleep() {
        System.out.println("Person.sleep");
    }
}

/**
 * 子类继承抽象父类，如果子类不是抽象类，需要覆写父类中所有的抽象方法
 */
class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        // 调用抽象父类构造器
        super(name, age);
    }

    /**
     * 覆写抽象父类中的抽象方法
     */
    @Override
    public void eat() {
        System.out.println("Student.eat");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        // 编译错误，抽象类不能直接实例化
        // Person per = new Person();

        // 抽象类可以通过子类实例化
        Person per = new Student("张三", 20);
        // 调用的是被子类覆写的方法
        per.eat(); // Student.eat
    }
}
