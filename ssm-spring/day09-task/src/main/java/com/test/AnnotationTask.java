package com.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class AnnotationTask {
    private static int count = 0;

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void date() {
        System.out.println(LocalDateTime.now());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void total() {
        System.out.println(LocalDateTime.now() + "，count= " + ++count);
    }
}
