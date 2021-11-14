package com.test.api.day17;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class MyTask extends TimerTask {
    private int count = 0;

    @Override
    public void run() {
        // 模拟延时处理
        if (++count % 5 == 0) {
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 模拟正常业务逻辑处理时间
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "->" + LocalDateTime.now() + ",count = " + count);
    }
}

/**
 * java中所有的定时任务都通过一个单独的线程进行管理
 * 调度任务需要继承java.util.TimeTask
 * 任务的启动需要依赖java.util.Timer类
 */
public class TimerTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        // schedule执行间隔是固定的，即使之前出现了延迟，也会按照设定的间隔执行
        /*
            Timer-0->2021-11-14T13:24:50.325,count = 1
            Timer-0->2021-11-14T13:24:53.289,count = 2
            Timer-0->2021-11-14T13:24:56.295,count = 3
            Timer-0->2021-11-14T13:24:59.295,count = 4
            Timer-0->2021-11-14T13:25:09.318,count = 5  13:25:02开始的定时任务
            Timer-0->2021-11-14T13:25:09.827,count = 6  下一次执行时间已经过了，立即执行一次，调整当前时间为开始时间
            Timer-0->2021-11-14T13:25:12.839,count = 7
            Timer-0->2021-11-14T13:25:15.844,count = 8
            Timer-0->2021-11-14T13:25:18.842,count = 9
         */
        timer.schedule(new MyTask(),
                TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS),
                TimeUnit.MILLISECONDS.convert(3, TimeUnit.SECONDS));

        // scheduleAtFixedRate按照固定时间间隔执行定时任务，延迟需要立即补足缺少的次数
        /*
            Timer-0->2021-11-14T13:18:47.274,count = 1
            Timer-0->2021-11-14T13:18:50.238,count = 2
            Timer-0->2021-11-14T13:18:53.250,count = 3
            Timer-0->2021-11-14T13:18:56.244,count = 4
            Timer-0->2021-11-14T13:19:06.244,count = 5  13:18:59开始的定时任务
            Timer-0->2021-11-14T13:19:06.757,count = 6  下一次执行时间一斤过了，13:19:06之前少执行2次
            Timer-0->2021-11-14T13:19:07.269,count = 7  13:19:06之前少执行2次，13:18:52、13:18:55，需要补足
            Timer-0->2021-11-14T13:19:08.246,count = 8
            Timer-0->2021-11-14T13:19:11.253,count = 9
            Timer-0->2021-11-14T13:19:21.251,count = 10
         */
        timer.scheduleAtFixedRate(new MyTask(),
                TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS),
                TimeUnit.MILLISECONDS.convert(3, TimeUnit.SECONDS));

        // 优雅停止定时任务
        TimeUnit.SECONDS.sleep(30);
        timer.cancel();
    }
}
