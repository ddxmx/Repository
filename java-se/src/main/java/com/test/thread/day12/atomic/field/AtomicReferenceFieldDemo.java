package com.test.thread.day12.atomic.field;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

class Resource {
    // 如果在类内部进行使用AtomicReferenceFieldUpdater进行cas操作，则属性可以声明为private
    public volatile Boolean isInit = Boolean.FALSE;

    // 声明属性更新是原子性的
    AtomicReferenceFieldUpdater<Resource, Boolean> fieldUpdater
            = AtomicReferenceFieldUpdater.newUpdater(Resource.class, Boolean.class, "isInit");

    public void init() {
        // cas操作，同一时刻只会有一个线程cas成功，其他线程cas失败或者自旋等待
        if (fieldUpdater.compareAndSet(this, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName() + " ---- start init, need 1 second");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ---- end init....");
            // AtomicReferenceFieldUpdater会直接修改原属性值
            System.out.println(isInit);
        } else {
            System.out.println("已经有其他线程在进行初始化操作....");
        }
    }
}

public class AtomicReferenceFieldDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();

        // 5个线程并发去修改资源类中的引用类型属性
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 在不同线程中，操作同一个对象的属性
                    resource.init();
                }
            }, "线程-" + i).start();
        }
    }
}
