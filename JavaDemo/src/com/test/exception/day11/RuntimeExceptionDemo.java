package com.test.exception.day11;

/**
 * java异常的顶级父类为Throwable
 * |- Error：java虚拟机的严重错误，程序中无法处理
 * |- Exception：程序中需要处理的异常
 * --|- 编译时异常（受检异常）：IOException、SQLException，强制需要处理，否则编译不通过
 * --|- 运行时异常（非受检异常，RuntimeException）:
 * NullPointerException、ArrayIndexOutOfBoundsException、ClassCastException、NumberFormatException、ArithmeticException
 * 不强制处理，但是一旦发生异常，且未使用try-catch处理，也会导致中断程序
 * 所以程序中对于受检异常和非受检异常都需要进行异常处理
 */
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        int[] array = null;
        // java.lang.NullPointerException
        System.out.println(array.length);

        array = new int[3];
        // java.lang.ArrayIndexOutOfBoundsException: 3
        System.out.println(array[3]);

        // java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.String
        String str = (String) new Object();

        // java.lang.NumberFormatException: For input string: "abc"
        System.out.println(Integer.parseInt("abc"));

        // java.lang.ArithmeticException: / by zero
        System.out.println(10 / 0);
    }
}
