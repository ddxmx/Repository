package com.test.day15;

abstract class User {
    public abstract String getContent();

    public void talk() {
        System.out.println(getContent());
    }
}

class Teacher extends User {
    @Override
    public String getContent() {
        return "我是一个老师";
    }
}

class Worker extends User {
    @Override
    public String getContent() {
        return "我是一个工人";
    }
}

/**
 * 模板设计模式
 */
public class TemplateDemo {
    public static void main(String[] args) {
        new Teacher().talk(); //我是一个老师
        new Worker().talk(); //我是一个工人
    }
}
