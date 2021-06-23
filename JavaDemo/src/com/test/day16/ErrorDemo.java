package com.test.day16;

/**
 * Error异常分为栈异常和堆异常
 */
public class ErrorDemo {
    public static void main(String[] args) {
        //java.lang.StackOverflowError
        main(args);

        //JVM最大内存限制为32m时，java.lang.OutOfMemoryError: Java heap space
        Integer[] array = new Integer[1024 * 1024 * 1024];
    }
}
