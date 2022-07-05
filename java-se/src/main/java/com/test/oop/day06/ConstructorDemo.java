package com.test.oop.day06;

/**
 * 构造器：一般用于对类中的属性初始化
 * 一个类中至少会存在一个构造器，如果类中没有明确的定义一个构造器，会默认生成一个无参的，什么都不做的构造器
 * 如果类中明确定义了构造器，则默认的构造器不再生成
 * 构造器的名称必须和类名称一致，且没有任何的返回值声明（void也不允许）
 * 多个构造器之间形成构造器的重载
 */
class Student {
    String name;
    int age;

    /**
     * 如果没有明确定义构造器，则当前类会默认生成如下的构造器
     * 实际上默认生成的构造器的访问权限，和类的访问权限一致
     */
    public Student() {
    }

    public Student(String n, int a) {
        // 在构造器中对类中的属性进行初始化
        name = n;
        age = a;
    }

    public void study() {
        System.out.println("Student.study");
    }

    public void printInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        // 实例化对象时，实际上就是调用构造器：new 构造器()
        Student stu = new Student();
        stu.study(); // Student.study
        // 对象中的属性没有手动赋值时，默认值为对应数据类型的默认值
        stu.printInfo(); // 姓名：null，年龄：0

        Student stu2 = new Student("张三", 12);
        stu2.printInfo(); // 姓名：张三，年龄：12
    }
}