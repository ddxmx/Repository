package com.test.jdk5.day22;

import java.util.Arrays;

interface Info {
    public void talk();
}

/**
 * 自定义的枚举类默认继承自 java.lang.Enum，因此不允许显示继承其他类
 */
enum Sex implements Info {
    MALE("男") {
        @Override
        public void show() {
            System.out.println("MALE.show");
        }

        @Override
        public void talk() {
            System.out.println("MALE.talk");
        }
    }, FEMALE("女") {
        @Override
        public void show() {
            System.out.println("FEMALE.show");
        }

        @Override
        public void talk() {
            System.out.println("FEMALE.talk");
        }
    };

    private String name;

    /**
     * 枚举类的构造器使用private封装
     */
    private Sex(String name) {
        this.name = name;
    }

    /**
     * 枚举类常量值需要覆写抽象方法
     */
    public abstract void show();
}

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Sex.MALE); // MALE

        /*
            枚举类的常量，相当于是枚举类中的内部类
            因此，通过getClass()方法获取的是内部类常量的类名称，必须使用getDeclaringClass()方法才能获取枚举类的类名称
         */
        System.out.println(Sex.MALE.getClass().getName()); // com.test.jdk5.day22.Sex$1
        System.out.println(Sex.MALE.getDeclaringClass().getName()); // com.test.jdk5.day22.Sex
        System.out.println(Sex.MALE.getDeclaringClass().getSuperclass().getName()); // java.lang.Enum
        Arrays.asList(Sex.MALE.getDeclaringClass().getInterfaces()).forEach(e -> System.out.println(e.getName())); // com.test.jdk5.day22.Info

        System.out.println("***********************");
        // java.lang.Enum枚举类中的方法
        // 获取枚举类中所有的元素
        Sex[] sexes = Sex.values();
        System.out.println(Arrays.toString(sexes)); // [MALE, FEMALE]

        // 将字符串转换为枚举类型
        Sex female = Sex.valueOf("FEMALE");
        System.out.println(female); // FEMALE，如果不匹配，抛出异常java.lang.IllegalArgumentException: No enum constant com.test.jdk5.day22.Sex.XXX

        System.out.println("***********************");
        /*
            0->MALE
            1->FEMALE
         */
        for (Sex sex : sexes) {
            // 返回枚举值声明的顺序和名称
            System.out.println(sex.ordinal() + "->" + sex.name());
        }

        // 调用枚举类实现的接口
        Sex.MALE.talk(); // MALE.talk
        Sex.MALE.show(); // MALE.show

        Sex.FEMALE.talk(); // FEMALE.talk
        Sex.FEMALE.show(); // FEMALE.show
    }
}

