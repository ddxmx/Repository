package com.test.day19;

/**
 * 内存可见性
 * 一个线程修改内存，其他线程有可能看不到。
 * 其他线程读取变量时，可能从寄存器或CPU缓存中读取。
 */
public class VolatileDemo {
    //volatile直接读写内存
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println(flag);
                    break;
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag已经被修改为：" + flag);
        }).start();
    }
}
