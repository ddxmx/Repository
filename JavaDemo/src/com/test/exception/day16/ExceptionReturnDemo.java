package com.test.exception.day16;

/**
 * try-catch-finally结构和return语句
 */
public class ExceptionReturnDemo {
    public static void main(String[] args) {
        // 无异常产生，try中return执行前先执行finally结构，导致finally中的return先于try中的return执行
        /*
            计算结果：5
            finally
            3
         */
        System.out.println(invoke(new String[]{"10", "2"}));

        System.out.println("***********************************");
        // 产生异常并处理，catch中return执行前先执行finally结构，导致finally中的return先于catch中的return执行
        /*
            catch
            finally
            3
         */
        System.out.println(invoke(new String[2]));

        System.out.println("***********************************");
        // 产生异常未处理
        /*
            finally
            3
         */
        System.out.println(invoke(null));
    }

    public static int invoke(String[] array) {
        try {
            int num1 = Integer.parseInt(array[0]);
            int num2 = Integer.parseInt(array[1]);
            int result = num1 / num2;
            System.out.println("计算结果：" + result);
            return 1;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}
