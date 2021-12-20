package com.test.exception.day11;

/**
 * 如下场景finally中的代码一定会被执行
 * 1、catch未匹配try中抛出的异常
 * 2、catch中抛出了异常
 * 3、try-catch语句存在return语句
 * <p>
 * 使用finally和不使用finally的区别：
 * 当程序抛出的异常未被处理时，finally中的语句会被执行，而try-catch-finally结构之后的语句不会被执行
 * 语句要保证在出现异常后也能够被执行，需要写在finally结构中
 */
public class FinallyDemo {
    public static void main(String[] args) {
        String[] array = new String[]{"10", "0"};

        /*
            finally
            Exception in thread "main" java.lang.ArithmeticException: / by zero
                at com.test.exception.day11.FinallyDemo.main(FinallyDemo.java:29)
         */
        try {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            System.out.println("计算结果：" + num1 / num2);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            // finally一般用于资源的关闭，如流的关闭、数据库连接关闭
            System.out.println("finally");
        }

        // 程序中出现的异常未被捕获，该语句未被执行，finally中的语句正常被执行
        System.out.println("hello world");
    }

}
