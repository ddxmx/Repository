package com.test.day08;

class Student {
    int number;
    int grade;
    int score;

    public String getInfo() {
        return "学号：" + number + "，年级：" + grade + "，成绩：" + score;
    }
}

/**
 * 对象数组，数据元素的类型为引用类型，和基本数据类型的数组操作一致
 */
public class ObjectArrayDemo {
    public static void main(String[] args) {
        //声明并实例化对象数组
        Student[] students = new Student[10];
        //为数组中的元素赋值
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            //学号[1,20]
            student.number = i + 1;
            //年级[1，6]
            student.grade = (int) (Math.random() * 6 + 1);
            //成绩[60,100]
            student.score = (int) (Math.random() * 41 + 60);
            students[i] = student;
        }
        /*
            遍历数组中元素：
            学号：1，年级：6，成绩：69
            学号：2，年级：2，成绩：79
            学号：3，年级：5，成绩：89
            学号：4，年级：5，成绩：78
            学号：5，年级：5，成绩：78
            学号：6，年级：2，成绩：95
            学号：7，年级：3，成绩：88
            学号：8，年级：3，成绩：85
            学号：9，年级：2，成绩：77
            学号：10，年级：2，成绩：74
         */
        listStudents(students);
        System.out.println("*************************************");
        /*
            打印3年级学生信息：
            学号：7，年级：3，成绩：88
            学号：8，年级：3，成绩：85
         */
        searchStudentsByGrade(students, 3);
        System.out.println("*************************************");
        /*
            按学生成绩排序后遍历：
            学号：6，年级：2，成绩：95
            学号：3，年级：5，成绩：89
            学号：7，年级：3，成绩：88
            学号：8，年级：3，成绩：85
            学号：2，年级：2，成绩：79
            学号：4，年级：5，成绩：78
            学号：5，年级：5，成绩：78
            学号：9，年级：2，成绩：77
            学号：10，年级：2，成绩：74
            学号：1，年级：6，成绩：69
         */
        sortStudentsByScore(students);
        listStudents(students);
    }

    /**
     * 遍历Student数组元素信息
     *
     * @param students
     */
    public static void listStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getInfo());
        }

    }

    /**
     * 根据grade查找学生信息
     *
     * @param students
     * @param gradeKey
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
     *
     * @param students
     */
    public static void sortStudentsByScore(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                //根据学生的成绩从大到小排序
                if (students[j].score < students[j + 1].score) {
                    //交换学生的信息
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }


}