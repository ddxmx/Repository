package com.test.exception.day16;

/**
 * 自定义异常只需要继承Exception类或RuntimeException类
 */
class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}

/**
 * 自定义异常
 */
public class MyExceptionDemo {
    public static void main(String[] args) {
        int age = -10;

        /*
            com.test.exception.day16.MyException: Age is invalid
                at com.test.exception.day16.MyExceptionDemo.checkAge(MyExceptionDemo.java:38)
                at com.test.exception.day16.MyExceptionDemo.main(MyExceptionDemo.java:24)
            hello world
         */
        try {
            checkAge(age);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("hello world");
    }

    public static void checkAge(int age) {
        if (age > 0) {
            System.out.println("年龄：" + age);
            return;
        }

        throw new MyException("Age is invalid");
    }
}
