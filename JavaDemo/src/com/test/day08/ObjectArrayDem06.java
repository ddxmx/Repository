package com.test.day08;

class Person06 {
    String name;
    int age;

    public Person06(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "name=" + name + "，age=" + age;
    }
}

/**
 * 对象数组，数据元素的类型为引用类型，其他和基本数据类型的数组操作一致
 */
public class ObjectArrayDem06 {
    public static void main(String[] args) {
        Person06 per = new Person06("李四", 22);

        //静态初始化
        Person06[] pers
                = new Person06[]{new Person06("张三", 20), per, new Person06("王五", 18)};
        /*
            name=张三，age=20
            name=李四，age=22
            name=王五，age=18
         */
        printPerson(pers);

        System.out.println("**********************************");

        //动态初始化
        Person06[] pers2 = new Person06[3];
        pers2[0] = new Person06("Tom", 24);
        pers2[1] = new Person06("Helen", 26);
        /*
            name=Tom，age=24
            name=Helen，age=26
         */
        printPerson(pers2);

    }

    public static void printPerson(Person06[] array) {
        for (int i = 0; i < array.length; i++) {
            if (null != array[i]) {
                System.out.println(array[i].getInfo());
            }
        }
    }
}
