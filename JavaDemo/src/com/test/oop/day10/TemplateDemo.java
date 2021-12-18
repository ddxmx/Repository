package com.test.oop.day10;

abstract class User {
    public abstract String getContent();

    public void talk() {
        System.out.println(getContent());
    }
}

class Teacher extends User {
    @Override
    public String getContent() {
        return "Teacher.getContent";
    }
}

class Worker extends User {
    @Override
    public String getContent() {
        return "Worker.getContent";
    }
}

/**
 * 模板设计模式
 * 父类规定了行为，子类需要覆写指定方法来实现行为执行
 */
public class TemplateDemo {
    public static void main(String[] args) {
        new Teacher().talk(); // Teacher.getContent
        new Worker().talk(); // Worker.getContent
    }
}
