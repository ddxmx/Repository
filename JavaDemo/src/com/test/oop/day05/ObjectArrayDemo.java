package com.test.oop.day05;

import java.util.Random;

class Student {
    int id;
    int grade;
    int score;

    public String getInfo() {
        return "学号：" + id + "，年级：" + grade + "，成绩：" + score;
    }
}

/**
 * 对象数组，数组元素的类型为引用类型，和基本数据类型的数组操作一致
 */
public class ObjectArrayDemo {
    public static void main(String[] args) {
        // 声明并实例化对象数组
        Student[] students = new Student[10];

        // 随机生成数组元素
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            // 学号[1,20]
            student.id = i + 1;
            // 年级[1，6]
            student.grade = new Random().nextInt(6) + 1;
            // 成绩[0,100]
            student.score = new Random().nextInt(101);
            students[i] = student;
        }

        /*
            学号：1，年级：3，成绩：95
            学号：2，年级：4，成绩：39
            学号：3，年级：4，成绩：89
            学号：4，年级：1，成绩：69
            学号：5，年级：1，成绩：66
            学号：6，年级：1，成绩：79
            学号：7，年级：5，成绩：38
            学号：8，年级：4，成绩：21
            学号：9，年级：3，成绩：87
            学号：10，年级：5，成绩：89
         */
        System.out.println("--------列出学生信息--------");
        listStudents(students);

        /*
            学号：1，年级：3，成绩：95
            学号：9，年级：3，成绩：87
         */
        System.out.println("--------遍历3年级学生信息--------");
        searchStudentsByGrade(students, 3);

        /*
            学号：1，年级：3，成绩：95
            学号：3，年级：4，成绩：89
            学号：10，年级：5，成绩：89
            学号：9，年级：3，成绩：87
            学号：6，年级：1，成绩：79
            学号：4，年级：1，成绩：69
            学号：5，年级：1，成绩：66
            学号：2，年级：4，成绩：39
            学号：7，年级：5，成绩：38
            学号：8，年级：4，成绩：21
         */
        System.out.println("--------按学生成绩倒序排列--------");
        sortStudentsByScore(students);
        listStudents(students);
    }

    /**
     * 遍历Student数组中学生信息
     */
    public static void listStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getInfo());
        }

    }

    /**
     * 根据grade查找学生信息
     */
    public static void searchStudentsByGrade(Student[] students, int gradeKey) {
        for (int i = 0; i < students.length; i++) {
            if (gradeKey == students[i].grade) {
                System.out.println(students[i].getInfo());
            }
        }
    }

    /**
     * 根据学生的成绩排序
     */
    public static void sortStudentsByScore(Student[] students) {
        // 冒泡排序
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                // 根据学生的成绩从大到小排序
                if (students[j].score < students[j + 1].score) {
                    // 交换学生的信息
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

}
