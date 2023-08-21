package com.test.exception.day10.throwable;

import java.util.Random;

/**
 * 自定义异常只需要继承Exception类或RuntimeException类
 * 一般都继承RuntimeException类或其子类，方便代码编写，语法上不需要强制处理异常
 */
class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        // 传递原始异常的堆栈信息
        super(message, cause);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        int value = new Random().nextInt(3);

        try {
            if (value == 0) {
                throw new ArithmeticException("value is zero");
            } else if (value == 2) {
                throw new ArrayIndexOutOfBoundsException("array index out of bounds");
            }
        } catch (ArithmeticException e) { // 捕获普通异常，抛出业务异常
            /*
                Exception in thread "main" com.test.exception.day10.throwable.MyException: 参数错误：0
	                at com.test.exception.day10.throwable.MyExceptionDemo.main(MyExceptionDemo.java:35)
             */
            throw new CustomException("参数错误：0");
        } catch (ArrayIndexOutOfBoundsException e) { // 捕获普通异常，抛出业务异常
            /*
                Exception in thread "main" com.test.exception.day10.throwable.MyException: 数组索引超过长度：2
                    at com.test.exception.day10.throwable.MyExceptionDemo.main(MyExceptionDemo.java:43)
                Caused by: java.lang.ArrayIndexOutOfBoundsException: array index out of bounds
                    at com.test.exception.day10.throwable.MyExceptionDemo.main(MyExceptionDemo.java:28)
             */
            throw new CustomException("数组索引超过长度：2", e);
        }
    }
}
