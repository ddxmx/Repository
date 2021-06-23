package com.test.day16;

import java.util.Date;

/**
 * java异常的顶级父类为Throwable
 * ----Error：为java虚拟机的严重错误，程序中无法处理
 * ----Exception：为程序中需要处理的异常
 * 1、---- 编译时异常（受检异常）：IOException,SQLException
 * 强制需要处理，否则编译不通过
 * 2、---- 运行时异常（非受检异常，RuntimeException）:NullPointerException,ArrayIndexOutOfBoundsException,ClassCastException,NumberFormatException,ArithmeticException
 * 不强制处理，但是一旦发生异常，且未使用try-catch处理，也会中断程序
 */
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        int[] array = null;
        //java.lang.NullPointerException
        //System.out.println(array[0]);

        array = new int[3];
        //java.lang.ArrayIndexOutOfBoundsException: 3
        //System.out.println(array[3]);

        Object date = new Date();
        //java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String
        //String str = (String)date;

        //java.lang.NumberFormatException: For input string: "abc"
        //int value = Integer.parseInt("abc");

        //java.lang.ArithmeticException: / by zero
        //System.out.println(10/0);
    }
}
