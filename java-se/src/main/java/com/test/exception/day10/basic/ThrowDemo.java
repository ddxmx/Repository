package com.test.exception.day10.basic;

class Message {
    public void register(int id) throws Exception {
        if (id <= 0) {
            // 手动抛出一个异常
            throw new Exception("Id is invalid.");
        }

        System.out.println("register id is " + id);
    }
}

/**
 * throw用于手动抛出一个异常
 * 实际开发中通常将系统异常捕获后，抛出业务异常
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Message msg = new Message();

        try {
            msg.register(-1001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
