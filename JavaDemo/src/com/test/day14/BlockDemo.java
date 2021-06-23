package com.test.day14;

/**
 * 类中结构执行的先后顺序
 * 父类静态属性/父类静态代码块->子类静态属性/子类静态代码块
 * ->父类实例属性/父类普通代码块->父类构造方法->子类实例属性/子类普通代码块->子类构造方法
 */
class Person {
    private String name = "张三";
    private int age = 20;
    private static String desc = "我是一个人";

    //静态代码块
    static {
        System.out.println("Person static block");
    }

    //非静态代码块
    {
        System.out.println("Person normal block");
    }

    public Person() {
        System.out.println("Person Constructor");
    }

    public Person(String name, int age, String desc) {
        this();
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

    public static String getDesc() {
        System.out.println("类中的静态方法");
        return desc;
    }

    public static void setDesc(String desc) {
        Person.desc = desc;
    }
}

class Student extends Person {
    private double score = 95.5;
    private static String info = "我是一个学生";

    static {
        System.out.println("Student static block");
    }

    {
        System.out.println("Student normal block");
    }

    public Student() {
        System.out.println("Student Constructor");
    }

    public Student(String name, int age, String desc, double score) {
        super(name, age, desc);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static String getInfo() {
        return info;
    }

    public static void setInfo(String info) {
        Student.info = info;
    }
}

/**
 * 代码块，用来初始化类或对象
 * 分为静态代码块和非静态代码块
 * 静态代码块：随着类的加载而执行，只执行一次
 * 非静态代码块：随着对象的创建而执行，每次创建对象都会执行
 * 主类中的静态块优先于主方法执行
 */
public class BlockDemo {
    static {
        System.out.println("Main static block");
    }

    {
        System.out.println("Main normal block");
    }

    public static void main(String[] args) {
        /*
            Main static block
            main method
            Main normal block
            Person static block
            Student static block
            Person normal block
            Person Constructor
            Student normal block
            Student Constructor

            Person normal block
            Person Constructor
            Student normal block
            Student Constructor
         */
        System.out.println("main method");
        new BlockDemo().test();
    }

    public void test() {
        new Student();
        System.out.println();
        new Student();
    }
}
