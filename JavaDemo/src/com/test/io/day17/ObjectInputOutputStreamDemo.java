package com.test.io.day17;

import java.io.*;

/**
 * 序列化的类必须要实现java.io.Serializable标识接口
 * 必须保证其中的所有属性也是可序列化的
 * 如果属性不需要序列化，需要使用transient修饰
 * 序列化操作不能操作static或transient修饰的属性
 */
class Person implements Serializable {
    public static final long serialVersionUID = -6849794470754667711L;

    private String name;

    // 表示不序列化该属性
    private transient int age;

    // static属性不会被序列化
    public static String country;

    public Person() {
    }

    public Person(String name, int age) {
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
public class ObjectInputOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person.country = "中华人民共和国";
        Person person = new Person("Tom", 20);
        System.out.println(person);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hello.txt"));
        outputStream.writeObject(person);
        outputStream.close();

        // 注释序列化的操作，重新执行反序列化操作，验证static属性并没有序列化到文件中
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("hello.txt"));
        Person person2 = (Person) inputStream.readObject();
        inputStream.close();
        /*
            Person Info:
              |- name = Tom
              |- age = 0
              |- country = null
         */
        System.out.println(person2);
    }
}
