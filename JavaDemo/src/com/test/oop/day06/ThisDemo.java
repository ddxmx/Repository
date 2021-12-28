package com.test.oop.day06;

import java.util.Objects;

/**
 * this的使用
 * |- this表示当前对象（当前哪个对象在调用该属性或方法，哪个对象就是当前对象）
 * |- this.属性  明确的表示当前的属性是类中的属性，和方法的同名形参区分开来
 * |- this.方法  明确的表示调用的是类中的方法
 * |- this() 表示调用类中的其他构造器
 * this调用类中其他构造器的语句，要放在构造器的首行，且不能形成递归调用
 * 存在多个构造器，至少要保留一个构造器不调用其他构造器，作为调用父类构造器的出口
 */
class Emp {
    private String name;
    private int age;
    private double salary = 2500.0;

    public Emp() {
        System.out.println("实例化Emp对象");
    }

    public Emp(String name, int age) {
        // 调用类中无参构造器
        this();
        // this.属性表示调用类中的属性，和构造器的参数区分
        this.name = name;
        this.age = age;
    }

    public Emp(String name, int age, double salary) {
        // 调用类中2个参数的构造器
        this(name, age);
        this.salary = salary;
    }

    /**
     * getter和setter方法
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void show() {
        // this.方法名()表示调用类中的方法
        System.out.println("姓名：" + this.getName() + "，年龄：" + this.getAge() + "，薪资：" + this.getSalary());
    }

    /**
     * 判断两个对象是否相等
     */
    public boolean equals(Emp emp) {
        if (null == emp) {
            return false;
        }

        if (this == emp) {
            return true;
        }

        if (Objects.equals(this.getName(), emp.getName())
                && this.age == emp.age
                && this.salary == emp.salary) {
            return true;
        }

        return false;
    }
}

public class ThisDemo {
    public static void main(String[] args) {
        /*
            实例化Emp对象
            姓名：Smith，年龄：24，薪资：3800.0
         */
        Emp emp = new Emp("Smith", 24, 3800.0);
        emp.show();

        /*
            实例化Emp对象
            姓名：Tom，年龄：22，薪资：2500.0
         */
        Emp emp2 = new Emp("Tom", 22);
        emp2.show();

        // 实例化Emp对象
        Emp emp3 = new Emp("Tom", 22);
        System.out.println("emp equals emp ?：" + emp.equals(emp)); // emp equals emp ?：true
        System.out.println("emp equals emp2 ?：" + emp.equals(emp2)); // emp equals emp2 ?：false
        System.out.println("emp2 equals emp3 ?：" + emp2.equals(emp3)); // emp2 equals emp3 ?：true
    }
}