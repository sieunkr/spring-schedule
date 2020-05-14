package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class JobConfig {

    private final static String JOB_KEY = "sampleJobA";

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(JobOne.class).withIdentity(JOB_KEY)
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)
                .withIdentity("TriggerA")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *"))
                .build();
    }
}