package com.test.api.day15.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

@Data
@AllArgsConstructor
class Student {
    private String name;
    private int age;
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

        // 按照年龄从小到大排序，年龄相同，按照姓名字母反向排序
        Comparator<Student> studentComparator = (s1, s2) -> {
            if (s1.getAge() < s2.getAge()) {
                return -1;
            } else if (s1.getAge() > s2.getAge()) {
                return 1;
            } else {
                return s2.getName().compareTo(s1.getName());
            }
        };
        Arrays.sort(students, studentComparator);

        // [Student{name='tom', age=22}, Student{name='jack', age=22}, Student{name='jerry', age=23}, Student{name='helen', age=24}]
        System.out.println(Arrays.toString(students));
    }
}
