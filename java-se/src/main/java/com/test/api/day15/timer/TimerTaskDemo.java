package com.test.api.day15.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TimerTask实际上也实现了Runnable接口
 * 调度任务需要继承java.util.TimerTask
 */
class MyTask extends TimerTask {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            int tempCount = count.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + "->" + LocalDateTime.now() + ",count = " + tempCount);

            // 模拟延时处理
            if (tempCount % 5 == 0) {
                TimeUnit.SECONDS.sleep(7);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * java中所有的定时任务都通过一个单独的线程进行管理
 * 任务的启动需要依赖java.util.Timer类
 */
public class TimerTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        MyTask task = new MyTask();

        // schedule执行间隔是固定的，即使之前出现了延迟，也会按照设定的间隔执行
        /*
            Timer-0->2023-08-27T00:20:01.489,count = 1
            Timer-0->2023-08-27T00:20:04.450,count = 2
            Timer-0->2023-08-27T00:20:07.461,count = 3
            Timer-0->2023-08-27T00:20:10.474,count = 4
            Timer-0->2023-08-27T00:20:13.484,count = 5
            // 00:20:13开始的定时任务，00:20:20执行结束。原下次执行时间：00:20:16、00:20:19已经过了，立即执行一次，调整当前时间为开始时间
            Timer-0->2023-08-27T00:20:20.489,count = 6
            Timer-0->2023-08-27T00:20:23.501,count = 7
            Timer-0->2023-08-27T00:20:26.512,count = 8
            Timer-0->2023-08-27T00:20:29.527,count = 9
            Timer-0->2023-08-27T00:20:32.533,count = 10
         */
        timer.schedule(task, 1000, 3000);

        // scheduleAtFixedRate按照固定时间间隔执行定时任务，延迟需要立即补足缺少的次数
        /*
            Timer-0->2023-08-27T00:24:53.126,count = 1
            Timer-0->2023-08-27T00:24:56.082,count = 2
            Timer-0->2023-08-27T00:24:59.080,count = 3
            Timer-0->2023-08-27T00:25:02.079,count = 4
            Timer-0->2023-08-27T00:25:05.078,count = 5
            // 00:25:05开始的定时任务，00:25:12执行结束。原下次执行时间：00:25:08、00:25:11已经过了，00:25:14之前少执行2次，需要全部补足
            Timer-0->2023-08-27T00:25:12.090,count = 6
            Timer-0->2023-08-27T00:25:12.090,count = 7
            Timer-0->2023-08-27T00:25:14.078,count = 8
            Timer-0->2023-08-27T00:25:17.075,count = 9
            Timer-0->2023-08-27T00:25:20.083,count = 10
         */
        timer.scheduleAtFixedRate(task, 1000, 3000);

        // 等待定时任务运行30秒
        TimeUnit.SECONDS.sleep(30);

        // 优雅停止定时任务
        timer.cancel();
    }
}
