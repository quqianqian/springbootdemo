package com.nd.zsp.taskscheduledemo.service;

import java.time.LocalDateTime;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("DynamicTask.MyRunnable.run()，" + LocalDateTime.now());
    }
}
