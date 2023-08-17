package com.test.oop.day06.bean;

/**
 * JavaBean的特点
 * （1）类的权限是public
 * （2）存在无参构造器
 * （3）属性使用private封装
 * （4）属性提供了setter和getter方法
 */
public class JavaBean {
    private String name;
    private int age;

    // 无参构造，通过反射进行对象实例化默认调用无参构造
    public JavaBean() {
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
}

