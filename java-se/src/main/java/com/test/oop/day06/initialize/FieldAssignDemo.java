package com.test.oop.day06.initialize;

/**
 * 属性赋值的先后顺序
 * （1）属性初始化赋值（对象实例化完成前）
 * （2）构造器赋值（对象实例化完成前）
 * （3）set方法赋值（对象实例化完成后）
 */
class Person {
    private String name = "张三";
    private int age = 18;

    public Person(String name, int age) {
        System.out.println("构造器执行前：name=" + this.name + ",age=" + this.age);
        this.name = name;
        this.age = age;
        System.out.println("构造器执行后：name=" + this.name + ",age=" + this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName方法执行前：name=" + this.name);
        this.name = name;
        System.out.println("setName方法执行后：name=" + this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge方法执行前：age=" + this.age);
        this.age = age;
        System.out.println("setAge方法执行后：age=" + this.age);
    }
}

public class FieldAssignDemo {
    public static void main(String[] args) {
        /*
            构造器执行前：name=张三,age=18
            构造器执行后：name=李四,age=16
         */
        Person per = new Person("李四", 16);
        /*
            setName方法执行前：name=李四
            setName方法执行后：name=王五
         */
        per.setName("王五");
        /*
            setAge方法执行前：age=16
            setAge方法执行后：age=19
         */
        per.setAge(19);
    }
}
