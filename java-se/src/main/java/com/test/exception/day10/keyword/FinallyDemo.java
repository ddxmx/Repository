package com.test.exception.day10.keyword;

/**
 * 1、如下场景，finally中的代码也一定会被执行
 * （1）try中未抛出异常
 * （2）try中抛出的异常被catch语句捕获
 * （3）try中抛出的异常未被catch语句捕获
 * （4）catch中抛出了异常
 * （5）try-catch结构存在return语句
 * 2、使用finally和不使用finally的区别：
 * 当程序抛出的异常未被处理时，finally中的语句会被执行，而try-catch-finally结构之后的语句不会被执行
 * 因此不管是否发生异常，都需要进行的操作需要放在finally语句中，如文件流关闭、数据库连接关闭等等
 */
public class FinallyDemo {
    public static void main(String[] args) {
        /*
            finally
            Exception in thread "main" java.lang.ArithmeticException: / by zero
                at com.test.exception.day11.FinallyDemo.main(FinallyDemo.java:22)
         */
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println("计算结果：" + num1 / num2);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }

        // 程序中出现的异常未被捕获，该语句未被执行，finally中的语句正常被执行
        System.out.println("hello world");
    }
}
