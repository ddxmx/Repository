package com.test.jdk5.day16.enumeration;

import java.util.Arrays;

interface Language {
    public void talk();
}

/**
 * 自定义的枚举类默认继承自 java.lang.Enum，因此不允许显示继承其他类
 * 枚举类可以实现接口
 */
enum Person implements Language {
    MALE("男") {
        @Override
        public void walk() {
            System.out.println("MALE.walk");
        }

        @Override
        public void talk() {
            System.out.println("MALE.talk");
        }
    },
    FEMALE("女") {
        @Override
        public void walk() {
            System.out.println("FEMALE.walk");
        }

        @Override
        public void talk() {
            System.out.println("FEMALE.talk");
        }
    };

    private String name;

    /**
     * 枚举类的构造器使用private封装
     * 枚举类构造方法，访问权限可以省略，默认为private
     */
    /*private*/ Person(String name) {
        this.name = name;
        System.out.println("Person实例化操作，name=" + name);
    }

    /**
     * 枚举类中可以定义抽象方法
     * 枚举类常量值需要覆写抽象方法
     */
    public abstract void walk();
}

public class EnumDemo {
    public static void main(String[] args) {
        // 获取枚举类常量时，将调用构造方法，实例化所有枚举常量
        // 枚举类的toString()方法获取的是枚举类常量的name信息
        System.out.println(Person.MALE); // MALE

        System.out.println("============================获取枚举类结构信息============================");
        // 枚举类的常量，相当于是枚举类中的内部类
        // 因此，通过getClass()方法获取的是内部类常量的类名称，必须使用getDeclaringClass()方法才能获取枚举类的类名称
        System.out.println(Person.MALE.getClass().getName()); // com.test.jdk5.day16.enumeration.Person$1
        System.out.println(Person.MALE.getDeclaringClass().getName()); // com.test.jdk5.day16.enumeration.Person
        System.out.println(Person.MALE.getDeclaringClass().getSuperclass().getName()); // java.lang.Enum
        Arrays.stream(Person.MALE.getDeclaringClass().getInterfaces()).forEach(e -> System.out.println(e.getName())); // com.test.jdk5.day16.enumeration.Language

        System.out.println("============================枚举类中方法使用============================");
        // java.lang.Enum枚举类中的方法
        // 获取枚举类中所有的元素
        Person[] persons = Person.values();
        System.out.println(Arrays.toString(persons)); // [MALE, FEMALE]

        // 将字符串转换为枚举类型
        // 如果不匹配，抛出异常java.lang.IllegalArgumentException
        Person female = Person.valueOf("FEMALE");
        System.out.println(female); // FEMALE

        /*
            0->MALE
            1->FEMALE
         */
        for (Person person : persons) {
            // 返回枚举值声明的顺序和名称
            System.out.println(person.ordinal() + "->" + person.name());
        }

        // 调用枚举类实现的接口
        Person.MALE.talk(); // MALE.talk
        Person.MALE.walk(); // MALE.walk
    }
}
