package com.test.io.day17.stream.serialization;

import java.io.*;

/**
 * 序列化的类必须要实现java.io.Serializable标识接口
 * 1、必须保证其中的所有属性也是可序列化的
 * 2、如果属性不需要序列化，需要使用transient修饰
 * 3、序列化操作不能操作static或transient修饰的属性
 */
class Student implements Serializable {
    // Settings设置后，在类名称上Atl+Enter自动生成
    private static final long serialVersionUID = -4178814393110425707L;

    private String name;

    // 不序列化该属性
    private transient int age;

    // static属性不会被序列化
    public static String country;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student Info:"
                + "\n  |- name = " + this.name
                + "\n  |- age = " + this.age
                + "\n  |- country = " + country;
    }
}

/**
 * 对象的序列化和反序列化
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "hello.txt";
        Student.country = "England";
        Student student = new Student("Tom", 20);
        /*
            Student Info:
              |- name = Tom
              |- age = 20
              |- country = England
         */
        System.out.println(student);

        // 序列化，将对象写入文件
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
        }

        // 不设置静态变量的值，否则所有的对象受到影响
        Student.country = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Student stu = (Student) in.readObject();
            /*
            Student Info:
              |- name = Tom
              |- age = 0
              |- country = null
            */
            System.out.println(stu);
        }
    }
}
