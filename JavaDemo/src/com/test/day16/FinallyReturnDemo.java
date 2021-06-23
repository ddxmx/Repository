package com.test.day16;

/**
 * try-catch-finally结构和return语句
 */
public class FinallyReturnDemo {
    public static void main(String[] args) {
        /*
            计算结果：5
            无论是否出现异常都会执行
            finally
         */
        //未出现异常
        System.out.println(test(new String[]{"10", "2"}));

        System.out.println("*************************************");
        /*
            java.lang.NumberFormatException: null
                at java.lang.Integer.parseInt(Integer.java:542)
                at java.lang.Integer.parseInt(Integer.java:615)
                at com.test.day16.FinallyReturnDemo.test(FinallyReturnDemo.java:10)
                at com.test.day16.FinallyReturnDemo.main(FinallyReturnDemo.java:5)
            处理异常
            无论是否出现异常都会执行
            finally
         */
        //出现NumberFormatException异常
        System.out.println(test(new String[2]));

        System.out.println("*************************************");
        /*
            无论是否出现异常都会执行
            finally
         */
        //出现try-catch未处理的异常
        System.out.println(test(null));
    }

    public static String test(String[] array) {
        try {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            int result = num1 / num2;
            System.out.println("计算结果：" + result);
            return String.valueOf(result);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println("处理异常");
            return "catch";
        } finally {
            //finally一般用于资源的关闭，如I0关闭、数据库连接关闭
            System.out.println("无论是否出现异常都会执行");
            return "finally";
        }
    }
}
