package com.test.exception.day16;

/**
 * 异常处理过程
 * 1、程序在正常执行过程中，一旦出现异常，就会在异常代码处生成一个异常对象并抛出
 * 一旦抛出异常，且未处理，其后的代码不再继续执行
 * 2、此时有两种处理方式
 * 1）try-catch-finally：
 * try{
 * // 可能存在异常的代码
 * }catch(异常类型1 变量名){
 * // 异常处理方式1
 * }
 * catch(异常类型2 变量名){
 * // 异常处理方式2
 * }
 * finally{     // 可选的结构
 * // 无论是否出现异常都会执行的代码
 * }
 * 3、try-catch-finally结构可以嵌套
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        /*
            参数不传递，满足ArrayIndexOutOfBoundsException异常时：
                传入的参数不足：java.lang.ArrayIndexOutOfBoundsException: 0
                hello world

            传递传入a b，满足NumberFormatException异常时：
                传入的参数非数字：For input string: "a"
                hello world

            参数传入10 0，满足Exception异常时：
                java.lang.ArithmeticException: / by zero
                    at com.test.exception.day16.ExceptionDemo.main(ExceptionDemo.java:37)
                hello world
         */
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int result = num1 / num2;
            System.out.println("计算结果：" + result);
        } catch (ArrayIndexOutOfBoundsException e) { // 多个catch只会执行一个
            System.out.println("传入的参数不足：" + e);
        } catch (NumberFormatException e) {
            System.out.println("传入的参数非数字：" + e.getMessage());
        } catch (Exception e) { // 异常类型存在子父类关系时，子类异常写在上面，父类异常写在下面，否则后续异常永远都无法被执行
            e.printStackTrace();
        }
        // 如果程序未处理异常，或程序中的异常语句未能匹配抛出的异常，则程序中断，异常后的语句不再继续执行
        System.out.println("hello world");
    }
}
