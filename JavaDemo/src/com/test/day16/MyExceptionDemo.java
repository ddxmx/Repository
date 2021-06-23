package com.test.day16;

/**
 * 自定义异常只需要继承Exception或RuntimeException类
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
        /*
            Exception in thread "main" com.test.day16.MyException: 年龄传入错误，请检查值是否合法
                at com.test.day16.MyExceptionDemo.main(MyExceptionDemo.java:18)
         */
        int age = -10;
        try {
            checkAge(age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkAge(int age) {
        if (age > 0) {
            System.out.println("年龄为：" + age);
        } else {
            throw new MyException("年龄传入错误，请检查值是否合法");
        }
    }
}
