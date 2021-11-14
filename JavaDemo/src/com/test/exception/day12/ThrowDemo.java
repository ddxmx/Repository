package com.test.exception.day12;

class Info {
    private int id;

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
            return;
        }

        // 手动抛出一个异常
        throw new Exception("Id is invalid.");
    }

    public int getId() {
        return id;
    }
}

/**
 * throw用于手动抛出一个异常
 * 实际开发中通过将系统异常捕获后，抛出一个业务异常
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Info info = new Info();
        try {
            info.register(-100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hello world");
    }
}
