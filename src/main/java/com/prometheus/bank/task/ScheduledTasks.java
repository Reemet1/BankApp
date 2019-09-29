package com.prometheus.bank.task;

import com.prometheus.bank.logger.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        Logger.logger.info("Scheduled task");
    }

}
