package com.test.day19;

/**
 * 线程安全的懒汉式单例模式
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("实例化对象");
    }

    public static Singleton getInstance() {
        //后续线程不再需要进行同步操作
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void show() {
        System.out.println("hello world");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            Singleton.getInstance().show();
        }).start();

        new Thread(() -> {
            Singleton.getInstance().show();
        }).start();

        new Thread(() -> {
            Singleton.getInstance().show();
        }).start();
    }
}
