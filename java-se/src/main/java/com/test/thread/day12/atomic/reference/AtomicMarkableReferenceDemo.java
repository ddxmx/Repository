package com.test.thread.day12.atomic.reference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo {
    private static Account account = new Account("张三", 1000);
    private static boolean flag = false;
    private static boolean destFlag = true;

    // atomicMarkableAccount的任何操作不会影响account
    private static AtomicMarkableReference<Account> atomicMarkableAccount = new AtomicMarkableReference<>(account, flag);

    public static void main(String[] args) throws InterruptedException {
        Runnable personRunnable = new Runnable() {
            @Override
            public void run() {
                // 这种实现方式所有线程最终都操作成功，compareAndSet+自旋
                /*while (true) {
                    boolean[] markHolder = new boolean[1];
                    Account account = atomicMarkableAccount.get(markHolder);
                    boolean mark = markHolder[0];
                    Account destAccount = new Account(account.getName(), account.getBalance() + 10);
                    if (atomicMarkableAccount.compareAndSet(account, destAccount, mark, destFlag)) {
                        break;
                    }
                }*/

                // 这种实现方式所有线程最终只有一个能成功
                Account destAccount = new Account(account.getName(), account.getBalance() + 10);
                // atomicAccount只有未修改时value=account，只要被修改过，value!=account
                if (atomicMarkableAccount.compareAndSet(account, destAccount, flag, destFlag)) {
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
                // 增加如下操作后，导致compareAndSet再一次判断时，mark不相等
                atomicMarkableAccount.set(account, destFlag);
            }
            pool.submit(personRunnable);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(atomicMarkableAccount.getReference()); // Account(name=张三, balance=1000)
        System.out.println(account); // Account(name=张三, balance=1000)
    }
}
