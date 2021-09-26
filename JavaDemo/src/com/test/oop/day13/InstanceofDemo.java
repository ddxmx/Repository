package com.test.oop.day13;

class Person {
    public void sleep() {
        System.out.println("Person sleep");
    }

    public void walk() {
        System.out.println("Person walk");
    }
}

class Student extends Person {
    @Override
    public void sleep() {
        System.out.println("Student sleep");
    }

    @Override
    public void walk() {
        System.out.println("Student walk");
    }

    public void study() {
        System.out.println("Student study");
    }
}

class Worker extends Person {
    public void work() {
        System.out.println("Worker work");
    }
}

/**
 * 向下转型以及instanceof
 * a instanceof A：对象a是否是类A的实例
 */
public class InstanceofDemo {
    public static void main(String[] args) {
        //向上转型
        Person per1 = new Student();
        per1.sleep(); //Student sleep
        per1.walk(); //Student walk

        //per1.study(); //编译失败，p1是Person类型，其中没有定义study方法，方法是否可以被调用取决于声明类型
        //向下转型，前提：向下转型之前必须要先进行向上转型，否则会出现ClassCastException异常
        Student stu1 = (Student) per1;
        stu1.study(); //Student study

        System.out.println("****************************************");
        Person per2 = new Worker();
        //Student stu2 = (Student)per2; //运行失败，java.lang.ClassCastException: com.test.oop.day13.Worker cannot be cast to com.test.oop.day13.Student

        //为了避免向下转型出现异常，在向下转型时使用instanceof判断对象是否是类的实例
        if (per2 instanceof Student) {
            ((Student) per2).study();
        }
        if (per2 instanceof Worker) {
            ((Worker) per2).work();
        }

        System.out.println(per2 instanceof Person); //true
        System.out.println(per2 instanceof Student); //false
        System.out.println(per2 instanceof Worker); //true

        System.out.println("****************************************");
        Person p1 = new Student();
        Student s1 = (Student) p1; //编译运行都通过

        Object obj = new Student();
        Person p2 = (Person) obj; //编译运行都通过

        Person p3 = new Person();
        //Student s3 = (Student) p3; //编译通过，运行不通过

        //Student s4 = (Student) new Worker(); //编译不通过，Student和Worker类型没有父子关系，不能强转

        Object obj5 = new Student();
        //Worker worker = (Worker) obj5; //编译通过，运行不通过，Student和Worker类型没有父子关系，不能转换
    }
}
