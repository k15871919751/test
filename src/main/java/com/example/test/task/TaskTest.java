package com.example.test.task;

import com.example.test.dao.TaskDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
//@EnableScheduling
@Slf4j
public class TaskTest implements SchedulingConfigurer {

//    @Scheduled(cron = "0/2 * * * * ?")
//    private  static void test() {
//        log.info("执行的时间为{}", LocalDateTime.now());
//    }

    @Autowired
    private TaskDao task;

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> System.out.println("执行动态定时任务:" + LocalDateTime.now().toLocalTime()),
                triggerContext -> {
                    String cron = task.getCron(1);
                    if (cron != null) {
                        return new CronTrigger(cron).nextExecutionTime(triggerContext);
                    }
                    return null;
                }
        );

    }


}
