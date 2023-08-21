package com.test.exception.day10.throwable;

import java.util.Date;

/**
 * java异常的顶级父类为Throwable
 * （1）Error：java虚拟机的严重错误，发生后程序中无法处理。分为栈异常和堆异常
 * （2）Exception：程序中需要处理的异常
 *   （A）编译时异常（受检异常，强制需要处理，否则编译不通过）：IOException、SQLException、ClassNotFoundException
 *   （B）运行时异常（非受检异常，RuntimeException）：NullPointerException、ArrayIndexOutOfBoundsException、
 * ClassCastException、NumberFormatException、IllegalArgumentException、ArithmeticException、InterruptedException
 * 不强制处理，但是一旦发生异常，且未使用try-catch处理，也会导致程序中断
 * 所以程序中对于受检异常和非受检异常都需要进行异常处理
 */
public class ThrowableDemo {
    public static void main(String[] args) {
        System.out.println("=============================Runtime Exception=============================");
        {
            String str1 = null;
            // java.lang.NullPointerException
            System.out.println(str1.length());

            int[] array = new int[3];
            // java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(array[3]);

            // java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.String
            String str = (String) new Object();

            // java.lang.NumberFormatException: For input string: "abc"
            int value = Integer.parseInt("abc");

            // java.lang.ArithmeticException: / by zero
            System.out.println(10 / 0);

            // 受检异常，必须进行异常处理
            try {
                Class.forName(Date.class.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("=============================Error=============================");
        {
            // 栈异常
            // java.lang.StackOverflowError
            main(args);

            // 堆异常，设置JVM参数：-Xmx20m
            // java.lang.OutOfMemoryError: Java heap space
            int size = 10 * 1024 * 1024;
            int[] array = new int[size];
        }
    }
}
