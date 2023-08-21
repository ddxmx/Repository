package com.test.exception.day10.keyword;

class Message {
    public void register(int id) throws IllegalArgumentException {
        if (id <= 0) {
            // 手动抛出一个异常
            throw new IllegalArgumentException("id is invalid");
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
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
