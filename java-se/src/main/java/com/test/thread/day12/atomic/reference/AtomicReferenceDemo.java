package com.test.thread.day12.atomic.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
class Account {
    private String name;
    private int balance;
}

/**
 * 引用类型的原子操作
 * 读取后赋值、修改多个属性操作都不是原子操作
 * AtomicReference所有的set、compareAndSet方法，都是设置一个新的对象
 */
public class AtomicReferenceDemo {
    private static Account account = new Account("张三", 1000);

    // atomicAccount的任何操作不会影响account
    // 也可以实例化时不传入初始值，再调用set方法传入
    private static AtomicReference<Account> atomicAccount = new AtomicReference<>(account);

    public static void main(String[] args) throws InterruptedException {
        Runnable personRunnable = new Runnable() {
            @Override
            public void run() {
                // 这种实现方式所有线程最终都操作成功，compareAndSet+自旋
                /*while (true) {
                    Account account = atomicAccount.get();
                    Account destAccount = new Account(account.getName(), account.getBalance() + 10);
                    if (atomicAccount.compareAndSet(account, destAccount)) {
                        break;
                    }
                }*/

                // 这种实现方式所有线程最终只有一个能成功
                Account destAccount = new Account(account.getName(), account.getBalance() + 10);
                // atomicAccount只有未修改时value=account，只要被修改过，value!=account
                if (atomicAccount.compareAndSet(account, destAccount)) {
                    System.out.println(Thread.currentThread().getName() + "执行成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "执行失败");
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        /*
            pool-1-thread-1执行成功
            pool-1-thread-2执行失败
            pool-1-thread-5执行成功
            pool-1-thread-3执行失败
            pool-1-thread-6执行失败
            pool-1-thread-4执行失败
            pool-1-thread-8执行失败
            pool-1-thread-7执行失败
            pool-1-thread-9执行失败
            pool-1-thread-10执行失败
         */
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                Thread.sleep(100);
                // 增加如下操作后，导致compareAndSet再一次满足条件，触发了类似ABA的问题
                atomicAccount.set(account);
            }
            pool.submit(personRunnable);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(atomicAccount.get()); // Account(name=张三, balance=1010)
        System.out.println(account); // Account(name=张三, balance=1000)
    }
}
