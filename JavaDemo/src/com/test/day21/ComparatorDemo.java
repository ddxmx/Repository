package com.test.day21;

import java.util.Arrays;
import java.util.Comparator;

class Student {

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Comparator比较器
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        Student per1 = new Student("jack", 22);
        Student per2 = new Student("helen", 24);
        Student per3 = new Student("tom", 22);
        Student per4 = new Student("jerry", 23);
        Student[] students = new Student[]{per1, per2, per3, per4};

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else {
                    return o2.getName().compareTo(o1.getName());
                }
            }
        });

        //[Student{name='tom', age=22}, Student{name='jack', age=22}, Student{name='jerry', age=23}, Student{name='helen', age=24}]
        System.out.println(Arrays.toString(students));
    }
}
