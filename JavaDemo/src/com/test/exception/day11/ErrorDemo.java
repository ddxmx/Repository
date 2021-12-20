package com.test.exception.day11;

/**
 * Error异常分为栈异常和堆异常
 */
public class ErrorDemo {
    public static void main(String[] args) {
        // 栈异常
        // java.lang.StackOverflowError
        main(args);

        // 堆异常
        // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        int[] array = new int[Integer.MAX_VALUE];
    }
}
