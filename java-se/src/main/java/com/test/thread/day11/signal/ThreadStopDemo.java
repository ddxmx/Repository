package com.test.thread.day11.signal;

class Monitor implements Runnable {
    private boolean runningFlag = true;

    /**
     * 提供方法用于设置标志位
     */
    public void setRunningFlag(boolean runningFlag) {
        this.runningFlag = runningFlag;
    }

    @Override
    public void run() {
        // 通过标志位控制线程运行
        while (runningFlag) {
            System.out.println(Thread.currentThread().getName() + "正在运行...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程终止的方法
 */
public class ThreadStopDemo {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();

        new Thread(monitor, "线程A").start();

        Thread.sleep(5000);

        monitor.setRunningFlag(false);
    }
}
