package com.test.day06.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrintTask {

    public void logTask() {
        System.out.println(PrintTask.class.getName());
    }

    public void timeTask() {
        System.out.println(LocalDateTime.now());
    }

}
