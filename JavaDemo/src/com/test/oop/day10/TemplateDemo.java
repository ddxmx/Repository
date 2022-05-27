package com.test.oop.day10;

abstract class User {
    /**
     * 提供了抽象方法用于子类覆写，实现不同子类细节
     */
    public abstract String getContent();

    /**
     * 父类中的方法规定了行为流程
     */
    public void talk() {
        System.out.println("User.talk start");
        System.out.println(getContent());
        System.out.println("User.talk stop");
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
 * 抽象类设计：模板设计模式
 * 父类规定了行为，子类需要覆写指定方法来实现部分行为细节
 */
public class TemplateDemo {
    public static void main(String[] args) {
        /*
            User.talk start
            Teacher.getContent
            User.talk stop
         */
        new Teacher().talk();

        /*
            User.talk start
            Worker.getContent
            User.talk stop
         */
        new Worker().talk();
    }
}
