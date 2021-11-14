package com.test.exception.day12;

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
        System.out.println(invokeInt(new String[]{"10", "2"}));

        System.out.println("***********************************");
        // 产生异常并处理，catch中return执行前先执行finally结构，导致finally中的return先于catch中的return执行
        /*
            catch
            finally
            3
         */
        System.out.println(invokeInt(new String[2]));

        System.out.println("***********************************");
        // 产生异常未处理
        /*
            finally
            3
         */
        System.out.println(invokeInt(null));

        System.out.println(invokeInt()); // 100
        System.out.println(invokeMessage().getValue()); // 50
    }

    public static int invokeInt(String[] array) {
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


    public static int invokeInt() {
        int num = 100;
        try {
            /*
                执行finally前已经将return的值保存下来
                因此，finally中对变量修改并不影响基本数据类型的返回
                但是引用数据类型在finally中实际修改的是同一块堆内存地址，导致返回的对象内容被修改
             */
            return num;
        } finally {
            num = 10;
        }
    }

    public static Message invokeMessage() {
        Message msg = new Message(30);
        try {
            return msg;
        } finally {
            msg.setValue(50);
        }
    }

}

class Message {
    private int value;

    public Message(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
