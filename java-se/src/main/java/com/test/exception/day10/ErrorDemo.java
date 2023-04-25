package com.test.exception.day10;

/**
 * Error异常分为栈异常和堆异常
 */
public class ErrorDemo {
    public static void main(String[] args) {
        // 栈异常
        // java.lang.StackOverflowError
        main(args);

        // 堆异常
        // 设置JVM参数：-Xmx20m
        // java.lang.OutOfMemoryError: Java heap space
        int size = 10 * 1024 * 1024;
        int[] array = new int[size];
    }
}
