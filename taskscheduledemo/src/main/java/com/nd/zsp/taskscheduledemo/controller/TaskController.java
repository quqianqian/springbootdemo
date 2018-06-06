package com.nd.zsp.taskscheduledemo.controller;

import com.nd.zsp.taskscheduledemo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;


    @GetMapping("/cron")
    public String cronScheduled() throws InterruptedException {
        taskService.cronScheduled();
        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
        return "cronScheduled";
    }


    @GetMapping("/rate")
    public String rateScheduled() throws InterruptedException {
       taskService.rateScheduled();
        log.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now());
        return "rateScheduled";
    }


    @GetMapping("/delay")
    public String delayScheduled() throws InterruptedException {
        taskService.delayScheduled();
        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
        return "delayScheduled";
    }

    @GetMapping("/start")
    public String startScheduled() {
        taskService.start();
        log.info("startScheduled 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
        return "startScheduled";
    }

    @GetMapping("/stop")
    public String stopScheduled() {
        taskService.stop();
        log.info("stopScheduled 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
        return "stopScheduled";
    }
}
