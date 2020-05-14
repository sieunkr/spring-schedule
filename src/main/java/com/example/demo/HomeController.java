package com.example.demo;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class HomeController {

    private final Scheduler scheduler;

    public HomeController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping
    public String findJobList() {

        //scheduler.getCalendarNames();

        try {
            JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey("sampleJobA"));

            //test..

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        return "d";
    }

}
