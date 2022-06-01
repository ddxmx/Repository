package com.test.exception.day11;

/**
 * 自定义异常只需要继承Exception类或RuntimeException类
 * 一般都继承RuntimeException类或其子类，方便代码编写，语法上不需要强制处理异常
 */
class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}

public class MyExceptionDemo {
    public static void main(String[] args) {
        int age = -10;

        /*
            com.test.exception.day11.MyException: age is invalid
                at com.test.exception.day11.MyExceptionDemo.main(MyExceptionDemo.java:25)
            hello world
         */
        try {
            if (age <= 0) {
                throw new MyException("age is invalid");
            }
            System.out.println("年龄：" + age);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("hello world");
    }
}
