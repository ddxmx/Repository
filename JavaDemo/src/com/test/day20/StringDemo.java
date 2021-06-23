package com.test.day20;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "hello"; //字面量直接入池
        String str2 = "hello"; //直接使用常量池的数据
        System.out.println(str1 == str2); //true

        System.out.println("***********************************");
        String str3 = str2;
        str3 += " world";
        System.out.println(str3); //hello world
        System.out.println(str2); //hello，字符串的值一旦创建不可修改

        System.out.println("***********************************");
        System.out.println("[" + new String() + "]"); //[]

        String str4 = "abc";
        String str5 = new String("abc"); //在堆空间中开辟
        System.out.println(str4 == str5); //false

        Person p1 = new Person("Tom", 20);
        Person p2 = new Person("Tom", 20);
        System.out.println(p1 == p2); //false
        System.out.println(p1.name.equals(p2.name)); //true
        System.out.println(p1.name == p2.name); //true，字符串直接赋值的方式，数据入常量池

        p1.name = "Jerry";
        System.out.println(p1.name); //Jerry
        System.out.println(p2.name); //Tom

        /*
            面试题
            String s = new String("abc");方式创建对象，在内存中创建了几个对象？
            两个：一个是堆空间中new出来的abc对象，另一个是常量池中的abc对象。
         */

        System.out.println("***********************************");
        {
            String s1 = "hello";
            String s2 = "world";
            String s3 = "helloworld";
            String s4 = "hello" + "world";
            String s5 = s1 + "world";
            String s6 = s1 + s2;
            String s7 = s6.intern();
            //final值在编译器就可以确定，保存在常量池中
            final String s8 = "hello";
            String s9 = s8 + "world";

            //字符串使用常量拼接，结果在常量池中；使用变量进行连接时，不会使用常量池，直接new新对象
            System.out.println(s3 == s4); //true
            System.out.println(s3 == s5); //false
            System.out.println(s3 == s6); //false
            System.out.println(s5 == s6); //false
            //intern()方法将堆中的数据入池后，返回常量池的地址
            System.out.println(s3 == s7); //true
            System.out.println(s3 == s9); //true
        }
    }
}