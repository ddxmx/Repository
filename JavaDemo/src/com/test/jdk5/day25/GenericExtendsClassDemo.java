package com.test.jdk5.day25;

class Note<T extends Number> {
    private T info;

    public Note(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}

/**
 * 泛型类定义时使用extends
 * 实例化类对象时，类型只能是其本身类型或子类类型
 * <p>
 * 为什么泛型类上只能使用extends，而不能使用super?
 * 类型擦除后变为<Object>，Object又是所有类型的父类型，所有类型就都可以作为T，是没有意义的事情。
 */
public class GenericExtendsClassDemo {
    public static void main(String[] args) {
        Note<Integer> note = new Note<>(123);
        Integer info = note.getInfo();
        System.out.println(info); //123

        Note<Double> note2 = new Note<>(123.45);
        Double info2 = note2.getInfo();
        System.out.println(info2); //123.45

        //Note<String> note = new Note<>("hello"); //编译失败，String不是Number类的子类

    }
}
