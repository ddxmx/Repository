package com.test.thread.day12;

/**
 * 守护线程
 * 在Java中有两类线程：用户线程、守护线程
 * 只要当前JVM实例中存在任何一个非守护线程没有结束，JVM就不会结束；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束
 * Daemon的作用是为其他线程的运行提供服务，守护线程最典型的应用就是 GC (垃圾回收器)
 */
public class DaemonDemo {
    public static void main(String[] args) {
        /*
            线程A是否是守护线程：true
            main是否是守护线程：false
            main当前第1次执行
            线程A当前第1次执行
            main当前第2次执行
            线程A当前第2次执行
            main当前第3次执行
            线程A当前第3次执行
         */
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "当前第" + (i + 1) + "次执行");
            }
        }, "线程A");

        // 设置线程为守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println(thread.getName() + "是否是守护线程：" + thread.isDaemon());

        // 主方法，非守护线程
        System.out.println(Thread.currentThread().getName() + "是否是守护线程：" + Thread.currentThread().isDaemon());

        // 先于守护线程执行完成。主方法执行完成后，JVM退出，守护线程停止执行
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "当前第" + (i + 1) + "次执行");
        }
    }
}
