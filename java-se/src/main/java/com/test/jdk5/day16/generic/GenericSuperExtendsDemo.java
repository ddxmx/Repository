package com.test.jdk5.day16.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
}

class Student extends Person {
}

class Teacher extends Person {
}

/**
 * 通配符上限和下限
 * ? extend T
 * ? super T
 */
public class GenericSuperExtendsDemo {
    public static void main(String[] args) {
        // 理解?是一个实参类型
        List<Student> studentList = new ArrayList<>(Arrays.asList(new Student()));
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person()));
        List<Object> objectList = new ArrayList<>();

        // testExtendsList参数类型必须是Person类或Person的子类
        testExtendsList(studentList);
        testExtendsList(personList);
        // 编译错误，类型不是Person类或Person的子类
        // testExtendsList(objectList);

        // testSuperList参数类型必须是Person类或Person的父类
        // 编译错误，类型不是Person类或Person的父类
        // testSuperList(studentList);
        testSuperList(personList);
        testSuperList(objectList);
    }

    public static void testExtendsList(List<? extends Person> list) {
        // 编译时只知道类型是Person类或Person的子类，不知道具体是哪个子类，只能使用Person接收
        Person per = list.get(0);

        // extends不可以写入数据：
        // 编译错误，无法确定其中的元素是Person的哪个子类类型
        // list.add(new Student());
        // list.add(new Person());

        // null允许添加
        list.add(null);
    }

    public static void testSuperList(List<? super Person> list) {
        // 编译时只知道类型是Person类或Person类的父类，不知道具体是哪个父类，只能使用Object接收
        Object obj = list.get(0);

        // super可以写入数据：
        // 明确的知道其中的元素是Person类或Person类的父类，因此传入Person类型肯定能够被接收
        list.add(new Person());
        list.add(new Student()); // Student对象也是一个Person实例
        // list.add(new Object()); // 编译错误
    }
}
