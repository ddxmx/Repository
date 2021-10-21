package com.test.exception.day16;

/**
 * Error异常分为栈异常和堆异常
 */
public class ErrorDemo {
    public static void main(String[] args) {
        // java.lang.StackOverflowError
        main(args);

        // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
        int[] array = new int[Integer.MAX_VALUE];
    }
}
