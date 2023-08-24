package com.test.thread.day11.signal;

/**
 * volatile：内存可见性，并不能保证操作的原子性
 * 一个线程修改共享内存，其他线程有可能读取不到更新后的值。
 * 其他线程读取变量时，可能从寄存器或CPU缓存中读取。
 * synchronized也实现了内存可见性
 */
public class VolatileDemo {
    // volatile直接读写内存
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + "运行，获取flag=" + flag);
                        break;
                    }
                }
            }
        }, "线程A").start();

        // 线程2修改共享变量值
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag = true;
                System.out.println(Thread.currentThread().getName() + "运行，修改flag=" + flag);
            }
        }, "线程B").start();
    }
}
