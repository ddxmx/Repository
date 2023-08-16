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

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class MyExceptionDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int value = random.nextInt(3);

        try {
            if (value == 0) {
                throw new ArithmeticException("value is zero");
            } else if (value == 2) {
                throw new ArrayIndexOutOfBoundsException("array index out of bounds");
            }
        } catch (ArithmeticException e) { // 捕获普通异常，抛出业务异常
            /*
                Exception in thread "main" com.test.exception.day10.MyException: 参数错误：0
	                at com.test.exception.day10.MyExceptionDemo.main(MyExceptionDemo.java:35)
             */
            throw new MyException("参数错误：0");
        } catch (ArrayIndexOutOfBoundsException e) { // 捕获普通异常，抛出业务异常
            /*
                Exception in thread "main" com.test.exception.day10.MyException: 数组索引超过长度：2
                    at com.test.exception.day10.MyExceptionDemo.main(MyExceptionDemo.java:43)
                Caused by: java.lang.ArrayIndexOutOfBoundsException: array index out of bounds
                    at com.test.exception.day10.MyExceptionDemo.main(MyExceptionDemo.java:28)
             */
            throw new MyException("数组索引超过长度：2", e);
        }
    }
}
