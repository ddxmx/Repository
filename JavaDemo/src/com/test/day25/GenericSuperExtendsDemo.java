package com.test.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
}

class Student extends Person {
}

/**
 * 通配符上限和下限
 */
public class GenericSuperExtendsDemo {
    public static void main(String[] args) {
        //理解?是一个实参类型
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        Student student = new Student();
        List<Student> studentList = new ArrayList<>(Arrays.asList(student));
        List<Person> personList = new ArrayList<>(Arrays.asList(student));
        List<Object> objectList = new ArrayList<>();

        //list1参数类型必须是Person类或Person的子类
        list1 = studentList;
        list1 = personList;
        //list1 = objectList; //编译失败，类型不是Person类或Person的子类

        //list2参数类型必须是Person类或Person的父类
        //list2 = studentList; //编译失败，类型不是Person类或Person的父类
        list2 = personList;
        list2 = objectList;

        //读取数据：
        list1 = studentList;
        //编译时只知道类型是Person类或Person的子类，不知道具体是哪个子类，只能使用Person接收
        Person per = list1.get(0);

        list2 = personList;
        //编译时只知道类型是Person类或Person类的父类，不知道具体是哪个父类，只能使用Object接收
        Object obj = list2.get(0);

        //写入数据：
        //编译失败，无法确定其中的元素是Person的哪个子类类型
        //list1.add(new Student());
        //list1.add(new Person());

        //明确的知道其中的元素是Person类或Person类的父类，因此传入Person类型肯定能够被接收
        list2.add(new Person());
        list2.add(new Student()); //Student对象也是一个Person实例
        //list2.add(new Object()); //编译失败
    }
}
