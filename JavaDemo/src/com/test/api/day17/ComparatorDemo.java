package com.test.api.day17;

import java.util.Arrays;

class Student {
    private String name;
    private int age;

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
 * 项目中引用的类对象需要排序，但无法修改源码。当前情况下，可以使用Comparator接口实现对象的排序
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        Student stu1 = new Student("jack", 22);
        Student stu2 = new Student("helen", 24);
        Student stu3 = new Student("tom", 22);
        Student stu4 = new Student("jerry", 23);
        Student[] students = new Student[]{stu1, stu2, stu3, stu4};

        // 按照年龄从小到大排序，年龄相同，按照姓名字母倒序排序
        Arrays.sort(students, (Student o1, Student o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });

        // [Student{name='tom', age=22}, Student{name='jack', age=22}, Student{name='jerry', age=23}, Student{name='helen', age=24}]
        System.out.println(Arrays.toString(students));
    }
}
