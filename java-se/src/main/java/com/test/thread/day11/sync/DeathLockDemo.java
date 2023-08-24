package com.test.thread.day11.sync;

import java.util.concurrent.TimeUnit;

class A {
    public void update() {
        System.out.println("A.update");
    }
}

class B {
    public void update() {
        System.out.println("B.update");
    }
}

/**
 * 死锁
 * 1、造成死锁的原因：在持有一个锁的同时去获取另一个锁
 * 2、释放锁的场景：
 * （1）执行完同步代码块，就会释放锁。（synchronized）
 * （2）在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放。（exception）
 * （3）在执行同步代码块的过程中，执行了锁所属对象的wait()方法，这个线程会释放锁，进入对象的等待池。(wait)
 * 3、不释放锁的场景：
 * （1）执行同步代码块的过程中，执行了Thread.sleep()方法，当前线程放弃CPU，开始休眠，在休眠中不会释放锁。
 * （2）在执行同步代码块的过程中，执行了Thread.yield()方法，当前线程放弃CPU，但不会释放锁。
 */
public class DeathLockDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (a) {
                            a.update();

                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            synchronized (b) {
                                b.update();
                            }
                        }

                    }
                }
        ).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    b.update();

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (a) {
                        a.update();
                    }
                }
            }
        }).start();
    }
}
