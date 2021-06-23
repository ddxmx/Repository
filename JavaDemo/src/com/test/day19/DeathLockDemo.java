package com.test.day19;

class A {
    public void get() {
        System.out.println("A get");
    }

    public void show() {
        System.out.println("A show");
    }
}

class B {
    public void get() {
        System.out.println("B get");
    }

    public void show() {
        System.out.println("B show");
    }
}

/**
 * 死锁
 * 释放锁的场景
 * （1）执行完同步代码块，就会释放锁。（synchronized）
 * （2）在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放。（exception）
 * （3）在执行同步代码块的过程中，执行了锁所属对象的wait()方法，这个线程会释放锁，进入对象的等待池。(wait)
 * 不释放锁的场景
 * （1）执行同步代码块的过程中，执行了Thread.sleep()方法，当前线程放弃CPU，开始睡眠，在睡眠中不会释放锁。
 * （2）在执行同步代码块的过程中，执行了Thread.yield()方法，当前线程放弃CPU，但不会释放锁。
 * （3）在执行同步代码块的过程中，其他线程执行了当前线程对象的suspend()方法，当前线程被暂停，但不会释放锁。
 */
public class DeathLockDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        //先获取a锁再尝试获取b锁
        new Thread(() -> {
            synchronized (a) {
                a.get();
                //sleep的目的是为了让其他线程先获取b锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    b.show();
                }
            }
        }).start();

        //先获取b锁，再尝试获取a锁
        new Thread(() -> {
            synchronized (b) {
                b.get();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    a.show();
                }
            }
        }).start();
    }
}
