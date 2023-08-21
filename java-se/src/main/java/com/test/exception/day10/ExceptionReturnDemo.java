package com.test.exception.day10;

import java.util.Arrays;

/**
 * try-catch-finally结构和return语句
 * （1）无异常产生，try中return执行前先执行finally结构，导致finally中的return先于try中的return执行
 * （2）产生异常并处理，catch中return执行前先执行finally结构，导致finally中的return先于catch中的return执行
 * （3）产生异常但未匹配，执行finally语句，finally中存在return导致直接结束，此时try中抛出的异常被屏蔽
 */
public class ExceptionReturnDemo {
    public static void main(String[] args) {
        System.out.println("========try和finally中都有return语句，程序执行无异常========");
        /*
            try
            finally
            3
         */
        System.out.println(arithmetic(10,2));

        System.out.println("========catch和finally中都有return语句，程序执行异常匹配catch========");
        /*
            catch
            finally
            3
         */
        System.out.println(arithmetic(10,0));

        System.out.println("========catch和finally中都有return语句，程序执行异常未匹配catch========");
        /*
            finally
            3
         */
        System.out.println(arithmetic(10,null));

        System.out.println(modifyBasicReturn()); // 100
        System.out.println(Arrays.toString(modifyReferReturn())); // [100, 2, 3]
    }

    public static int arithmetic(Integer num1,Integer num2) {
        try {
            int result = num1 / num2;
            System.out.println("try");
            return 1;
        } catch (ArithmeticException e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    /**
     * finally中修改return返回的基本数据类型变量
     * 执行finally前已经将return的值保存下来
     * 因此，finally中对变量修改并不影响基本数据类型的返回
     */
    public static int modifyBasicReturn() {
        int num = 100;
        try {
            // 返回前已经保存返回值副本
            return num;
        } finally {
            num = 10;
        }
    }

    /**
     *  finally中修改return返回的引用数据类型变量
     * 引用数据类型在finally中实际修改的是同一块堆内存地址，导致返回的对象内容被修改
     */
    public static int[] modifyReferReturn() {
        int[] array = new int[]{1, 2, 3};
        try {
            return array;
        } finally {
            array[0] = 100;
        }
    }
}
