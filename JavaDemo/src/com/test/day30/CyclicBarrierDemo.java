package com.test.day30;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrier用于多个线程互相等待，直到到达同一个同步点，再继续一起执行。
 * CountDownLatch	            CyclicBarrier
 * 减计数方式	                加计数方式
 * 计算为0时释放所有等待的线程	    计数达到指定值时释放所有等待线程
 * 计数为0时，无法重置	        计数达到指定值时，计数置为0重新开始
 * 调用countDown()方法计数减1，调用await()方法只进行阻塞，对计数没任何影响
 * 调用await()方法计数加1，若加1后的值不等于构造方法的值，则线程阻塞
 * 不可重复利用	                可重复利用
 * <p>
 * 1星龙珠已获得~
 * 2星龙珠已获得~
 * 5星龙珠已获得~
 * 7星龙珠已获得~
 * 4星龙珠已获得~
 * 3星龙珠已获得~
 * 6星龙珠已获得~
 * 6星龙珠：聚齐七颗龙珠，召唤神龙
 * 6星龙珠消失...
 * 1星龙珠消失...
 * 2星龙珠消失...
 * 4星龙珠消失...
 * 7星龙珠消失...
 * 5星龙珠消失...
 * 3星龙珠消失...
 * 4星龙珠再次获得~
 * 6星龙珠再次获得~
 * 3星龙珠再次获得~
 * 2星龙珠再次获得~
 * 5星龙珠再次获得~
 * 7星龙珠再次获得~
 * 1星龙珠再次获得~
 * 1星龙珠：聚齐七颗龙珠，召唤神龙
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int dragonBallSize = 7;
        /*
            public CyclicBarrier(int parties)
            public CyclicBarrier(int parties, Runnable barrierAction)
            parties 是参与线程的个数，第二个构造方法有一个 Runnable 参数，这个参数的意思是最后一个到达线程要做的任务
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(dragonBallSize, () -> System.out.println(Thread.currentThread().getName() + "：聚齐七颗龙珠，召唤神龙"));
        for (int i = 1; i <= dragonBallSize; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
                    System.out.println(Thread.currentThread().getName() + "已获得~");
                    /*
                        在CyclicBarrier上等待的线程数量达到parties，则所有线程被释放，继续执行。—— 正常情形
                        当前线程等待超时，则抛出TimeoutException异常，并停止等待，继续执行。
                        当前线程抛出 TimeoutException 异常时，其他线程会抛出 BrokenBarrierException 异常。
                     */
                    cyclicBarrier.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println(Thread.currentThread().getName() + "消失...");
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
                    System.out.println(Thread.currentThread().getName() + "再次获得~");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + "星龙珠").start();
        }
    }
}
