package com.test.thread.day12;

/**
 * 线程的生命周期，Thread.State类：新建、运行、阻塞、等待、计时等待、消亡
 * 一般线程经历如下五种状态：
 * 新建：创建了线程类对象，但尚未调用start()方法
 * 就绪：调用了start()方法，等待CPU的调用
 * 运行：获得CPU执行权（CPU时间片结束或调用yield()方法，回到就绪状态）
 * 阻塞：sleep、join、wait、等待同步锁（sleep时间结束、join优先执行的线程结束、notify、获取同步锁时，回到就绪状态）
 * 消亡：线程执行结束或被终止
 */
public class ThreadStateDemo {
}
