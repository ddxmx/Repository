package com.test.day16;

/**
 * 以下情况下finally中的代码一也定会被执行
 * 1、可能出现try-catch未捕获的异常
 * 2、catch语句中可能存在异常
 * 3、try-catch语句存在return语句
 */
public class FinallyDemo {
    public static void main(String[] args) {
        /*
                java.lang.NumberFormatException: null
                    at java.lang.Integer.parseInt(Integer.java:542)
                    at java.lang.Integer.parseInt(Integer.java:615)
                    at com.test.day16.FinallyDemo.main(FinallyDemo.java:7)
                无论是否出现异常都会执行
                try-catch-finally后的语句
         */
        //String[] array = new String[2];


        /*
            无论是否出现异常都会执行
            Exception in thread "main" java.lang.NullPointerException
                at com.test.day16.FinallyDemo.main(FinallyDemo.java:42)
         */
        //String[] array = null;

        /*
            计算结果：5
            无论是否出现异常都会执行
            try-catch-finally后的语句
         */
        String[] array = new String[]{"10", "2"};
        try {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            System.out.println("计算结果：" + num1 / num2);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            e.printStackTrace();
        } finally {
            //finally一般用于资源的关闭，如I0关闭、数据库连接关闭
            System.out.println("无论是否出现异常都会执行");
        }

        System.out.println("try-catch-finally后的语句");
    }
}
