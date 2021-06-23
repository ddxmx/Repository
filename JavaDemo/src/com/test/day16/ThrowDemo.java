package com.test.day16;

class Student {
    private int id;

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            //手动抛出一个异常
            throw new Exception("传入的id值非法");
        }
    }
}

/**
 * throw用于手动抛出一个异常
 * 实际开发中通过将异常捕获后，抛出一个业务层的异常
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Student stu = new Student();
        try {
            stu.register(-100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hello world");
    }
}
