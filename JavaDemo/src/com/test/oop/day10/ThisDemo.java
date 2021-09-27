package com.test.oop.day10;

/**
 * this的使用
 * |- this表示当前对象（当前哪个对象在调用该属性或方法，哪个对象就是当前对象）
 * |- this.属性  明确的表示当前的属性是类中的属性，和方法的同名形参区分开来
 * |- this.方法  明确的表示调用调用的是类中的方法
 * |- this() 表示调用类中的构造器
 * this调用类中其他构造器的语句，要放在构造器的首行，且不能形成递归调用
 * N个构造器，至少要保留一个构造器不调用其他构造器，作为出口
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
        // this.属性表示调用类中的属性
        this.name = name;
        this.age = age;
    }

    public Emp(String name, int age, double salary) {
        // 调用类中2个参数的构造器
        this(name, age);
        this.salary = salary;
    }

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

    public String show() {
        // this.方法
        return "雇员信息 -> 姓名：" + this.getName() + "，年龄：" + this.getAge() + "，薪资：" + this.getSalary();
    }

    /**
     * 判断2个对象是否相等
     *
     * @param emp
     * @return
     */
    public boolean equals(Emp emp) {
        if (null == emp) {
            return false;
        }

        if (this == emp) {
            return true;
        }

        if (null != emp.getName() && null != this.getName()) {
            if (this.getName().equals(emp.getName()) && this.age == emp.age && this.salary == emp.salary) {
                return true;
            }
        }

        return false;
    }
}

public class ThisDemo {
    public static void main(String[] args) {
        Emp emp = new Emp("Smith", 24, 3800.0);
        System.out.println(emp.show()); // 雇员信息 -> 姓名：Smith，年龄：24，薪资：3800.0

        Emp emp2 = new Emp("Tom", 22);
        System.out.println(emp2.show()); // 雇员信息 -> 姓名：Tom，年龄：22，薪资：2500.0

        Emp emp3 = new Emp("Tom", 22);

        System.out.println("emp和自身是否相等：" + emp.equals(emp)); // emp和自身是否相等：true
        System.out.println("emp和emp2是否相等：" + emp.equals(emp2)); // emp和emp2是否相等：false
        System.out.println("emp2和emp3是否相等：" + emp2.equals(emp3)); // emp2和emp3是否相等：true
    }
}
