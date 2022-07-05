package com.test.thread.day13;

/**
 * volatile：内存可见性
 * 一个线程修改共享内存，其他线程有可能读取不到更新后的值。
 * 其他线程读取变量时，可能从寄存器或CPU缓存中读取。
 * synchronized也实现了内存可见性
 */
public class VolatileDemo {
    // volatile直接读写内存
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        // 线程1根据flag标识，进行打印操作
        new Thread(() -> {
            while (true) {
                // synchronized也会强制读取共享内存
                // synchronized (VolatileDemo.class) {
                //     if (flag) {
                //         System.out.println(flag);
                //         break;
                //     }
                // }

                if (flag) {
                    System.out.println(flag);
                    break;
                }
            }
        }).start();

        // 线程2修改共享变量值
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
