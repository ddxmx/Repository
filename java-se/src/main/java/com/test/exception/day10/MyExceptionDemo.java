package com.test.exception.day10;

import java.util.Random;

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
        /*
            com.test.exception.day10.MyException: not pass
                at com.test.exception.day10.MyExceptionDemo.main(MyExceptionDemo.java:25)
         */
        try {
            Random random = new Random();
            if (random.nextInt(101) < 60) {
                throw new MyException("not pass");
            }
            System.out.println("pass");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
