package com.sopehl.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * This job is only printing the current date on console.
 */
public class DateJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("DateJob is executed. Current date -> " + new Date());
    }

}
