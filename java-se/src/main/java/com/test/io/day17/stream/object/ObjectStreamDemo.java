package com.test.io.day17.stream.object;

import java.io.*;

/**
 * 序列化的类必须要实现java.io.Serializable标识接口
 * 必须保证其中的所有属性也是可序列化的
 * 如果属性不需要序列化，需要使用transient修饰
 * 序列化操作不能操作static或transient修饰的属性
 */
class Student implements Serializable {
    public static final long serialVersionUID = -6849794470754667711L;

    private String name;

    // 表示不序列化该属性
    private transient int age;

    // static属性不会被序列化
    public static String country;

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
        return "Person Info:"
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
        Student.country = "中华人民共和国";
        Student student = new Student("Tom", 20);
        System.out.println(student);

        // 序列化，将对象写入文件
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(student);
        }

        // 不设置静态变量的值，否则所有的对象受到影响
        Student.country = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Student stu = (Student) inputStream.readObject();
            /*
            Person Info:
              |- name = Tom
              |- age = 0
              |- country = null
            */
            System.out.println(stu);
        }

    }
}
