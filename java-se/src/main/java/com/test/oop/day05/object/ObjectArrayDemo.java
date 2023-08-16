package com.test.oop.day05.object;

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
        Student[] students = genStudents(10);

        System.out.println("--------列出学生信息--------");
        listStudents(students);

        System.out.println("--------遍历3年级学生信息--------");
        searchStudentsByGrade(students, 3);

        System.out.println("--------按学生成绩倒序排列--------");
        sortStudentsByScore(students);
    }

    /**
     * 随机生成学生信息
     */
    public static Student[] genStudents(int size) {
        Student[] students = new Student[size];

        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            // 学号[1,20]
            student.id = i + 1;
            // 年级[1，6]
            Random random = new Random();
            student.grade = random.nextInt(6) + 1;
            // 成绩[0,100]
            student.score = random.nextInt(101);
            students[i] = student;
        }

        return students;
    }

    /**
     * 遍历Student数组中学生信息
     */
    public static void listStudents(Student[] students) {
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
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getInfo());
        }
    }

    /**
     * 根据grade查找学生信息
     */
    public static void searchStudentsByGrade(Student[] students, int gradeKey) {
        /*
            学号：1，年级：3，成绩：95
            学号：9，年级：3，成绩：87
         */
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (gradeKey == student.grade) {
                System.out.println(student.getInfo());
            }
        }
    }

    /**
     * 根据学生的成绩倒序排序
     */
    public static void sortStudentsByScore(Student[] students) {
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

        listStudents(students);
    }

}
