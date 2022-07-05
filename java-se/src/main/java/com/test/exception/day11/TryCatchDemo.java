package com.test.exception.day11;

/**
 * 1、异常处理过程
 * 程序在正常执行过程中，一旦出现异常，就会在异常代码处生成一个异常对象并抛出
 * 一旦抛出异常，且未处理，其后的代码不再继续执行
 * 抛出异常的方法，如果没有在调用处处理，则继续向上抛出，直到main方法
 * main方法中如还未处理，则JVM进行默认的异常处理：终止程序运行，打印异常信息
 * 2、异常处理结构
 * （1）try-catch-finally，可以嵌套
 * try{
 *      可能存在异常的代码
 * }catch(异常类型1 变量名){
 *      异常处理方式1
 * }
 * catch(异常类型2 变量名){
 *      异常处理方式2
 * }
 * finally{     // 可选的结构
 *      无论是否出现异常都会执行的代码
 * }
 * （2）throws
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        /*
            参数不传递，抛出ArrayIndexOutOfBoundsException异常时：
                传入的参数不足：java.lang.ArrayIndexOutOfBoundsException: 0
                hello world

            传递传入a b，抛出NumberFormatException异常时：
                传入的参数非数字：For input string: "a"
                hello world

            参数传入10 0，抛出ArithmeticException异常时：
                java.lang.ArithmeticException: / by zero
                    at com.test.exception.day11.TryCatchDemo.main(TryCatchDemo.java:43)
                hello world
         */
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int result = num1 / num2;
            System.out.println("计算结果：" + result);
        }
        // 匹配上一个catch条件后，就不再匹配其他catch条件
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("传入的参数不足：" + e);
        } catch (NumberFormatException e) {
            System.out.println("传入的参数非数字：" + e.getMessage());
        }
        // 异常类型存在父子类关系时，子类异常写在上面，父类异常写在下面，否则后续异常匹配代码永远都无法被执行到
        catch (Exception e) {
            e.printStackTrace();
        }

        // 如果程序未处理异常，或程序中的异常匹配语句未能匹配抛出的异常，则程序中断，异常后的语句不再继续执行
        System.out.println("hello world");
    }
}
