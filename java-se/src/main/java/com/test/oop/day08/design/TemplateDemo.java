package com.test.oop.day08.design;

abstract class Person {
    /**
     * 提供了抽象方法用于子类覆写，实现不同子类细节
     */
    public abstract String getContent();

    /**
     * 父类中的方法规定了行为流程
     */
    public void introduce() {
        System.out.println("Person.introduce start");
        System.out.println(getContent());
        System.out.println("Person.introduce stop");
    }
}

class Teacher extends Person {
    @Override
    public String getContent() {
        return "Teacher.getContent";
    }
}

class Worker extends Person {
    @Override
    public String getContent() {
        return "Worker.getContent";
    }
}

/**
 * 抽象类模板设计模式
 * 父类规定了行为，子类需要覆写指定方法来实现部分行为细节
 */
public class TemplateDemo {
    public static void main(String[] args) {
        /*
            Person.introduce start
            Teacher.getContent
            Person.introduce stop
         */
        new Teacher().introduce();

        /*
            Person.introduce start
            Worker.getContent
            Person.introduce stop
         */
        new Worker().introduce();
    }
}
