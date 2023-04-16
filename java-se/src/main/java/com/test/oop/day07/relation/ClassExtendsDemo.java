package com.test.oop.day07.relation;

class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
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
        System.out.println("Animal.eat");
    }

    public void sleep() {
        System.out.println("Animal.sleep");
    }
}

/**
 * 继承为了代码复用，子类和父类有公共的属性和方法，子类无需重复定义，直接继承父类即可
 * 继承便于功能扩展，也是实现多态的前提
 * 父类也叫做基类、超类，子类也叫做派生类
 * 一个父类可以被多个子类继承，但是一个子类只能直接继承一个父类，类具有单继承的限制，但是允许多层继承，A继承B，B继承C
 * 继承是is a的关系，如：苹果是水果，继承的两个类在实际设计时，应该存在一定的关联，属于同一类概念
 * 一个类如果没有明确的继承另外一个类，则默认继承java.lang.Object类，所有的类都直接或间接继承Object类
 * 子类继承父类，获取父类中所有的属性和方法，private属性和方法也会被继承，只是无法直接访问，可以通过setter或getter方法调用
 */
class Bird extends Animal {
    // Bird中扩展了父类的功能，新增了属性
    private int wing;

    public Bird() {
    }

    public Bird(String name, int age, int wing) {
        super(name, age);
        this.wing = wing;
    }

    public int getWing() {
        return wing;
    }

    public void setWing(int wing) {
        this.wing = wing;
    }

    /**
     * Bird中扩展了父类的功能，新增了方法
     */
    public void fly() {
        System.out.println("Bird.fly");
    }
}

public class ClassExtendsDemo {
    public static void main(String[] args) {
        Bird bird = new Bird("天鹅", 6, 2);
        // 调用从父类继承的方法获取父类属性
        System.out.println(bird.getName()); // 天鹅
        // 调用子类扩展的方法获取子类属性
        System.out.println(bird.getWing()); // 2
        // 调用从父类继承的方法
        bird.eat(); // Animal.eat
        // 调用子类扩展的方法
        bird.fly(); // Bird.fly
    }
}
