package com.test.day10;

class Person01 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 在set方法中进行逻辑处理
     *
     * @param age
     */
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

/**
 * 封装与隐藏
 */
public class EncapsulationDemo01 {
    public static void main(String[] args) {
        Person01 person = new Person01();

        // 属性在类外部直接访问，造成属性赋值的不合理
        // 属性进行封装，提供getter和setter方法，无法通过 对象.属性的方式获取和设置值
//        person.age = -10;
//        System.out.println(person.age);

        person.setAge(-10);
        System.out.println(person.getAge()); // 0
    }
}
