package com.test.exception.day11;

class Message {
    private int id;

    public void register(int id) throws Exception {
        if (id <= 0) {
            // 手动抛出一个异常
            throw new Exception("Id is invalid.");
        }

        this.id = id;
    }

    public int getId() {
        return id;
    }
}

/**
 * throw用于手动抛出一个异常
 * 实际开发中通常将系统异常捕获后，抛出一个业务异常
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Message msg = new Message();

        try {
            msg.register(-1001);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(msg.getId()); // 0
    }
}
