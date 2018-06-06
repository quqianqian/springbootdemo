package com.nd.zsp.taskscheduledemo.service;

import com.nd.zsp.taskscheduledemo.config.TaskConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

@Service
public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskScheduler taskScheduler;

    private ScheduledFuture<?> future;


    /*
     *cron表达式在线生成： http://www.pdtools.net/tools/becron.jsp
     * */
//    @Scheduled(cron = "0/1 * * * * *")
    public void cronScheduled() throws InterruptedException {
        Thread.sleep(3000);
        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
    }

//    @Scheduled(fixedRate = 1000)
    public void rateScheduled() throws InterruptedException {
        Thread.sleep(3000);
        log.info("scheduled2 每1秒执行一次：{}", LocalDateTime.now());
    }

//    @Scheduled(fixedDelay = 3000)
    public void delayScheduled() throws InterruptedException {
        Thread.sleep(5000);
        log.info("scheduled3 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }

    public void start() {
        stop();
        future = taskScheduler.schedule(new MyRunnable(), new CronTrigger("0/15 * * * * *"));
        log.info("DynamicTask.startCron() 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }

    public void stop() {
        if (future!=null){
            future.cancel(true);
        }
        log.info("DynamicTask.stopCron() 上次执行完毕后隔3秒继续执行：{}", LocalDateTime.now());
    }
}
