package com.test.exception.day16;

/**
 * 如下场景finally中的代码一定会被执行
 * 1、catch未匹配try中抛出的异常
 * 2、catch中抛出了异常
 * 3、try-catch语句存在return语句
 * <p>
 * 使用finally和不使用finally的区别：
 * 当程序抛出的异常未被处理时，finally中的语句会被执行，而try-catch-finally结构之后的语句不会被执行
 */
public class FinallyDemo {
    public static void main(String[] args) {
        String[] array = new String[]{"10", "abc"};

        /*
            java.lang.NumberFormatException: For input string: "abc"
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580)
                at java.lang.Integer.parseInt(Integer.java:615)
                at com.test.exception.day16.FinallyDemo.main(FinallyDemo.java:15)
            finally
            hello world
         */
        try {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            System.out.println("计算结果：" + num1 / num2);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            e.printStackTrace();
        } finally {
            // finally一般用于资源的关闭，如流的关闭、数据库连接关闭
            System.out.println("finally");
        }

        System.out.println("hello world");
    }
}
