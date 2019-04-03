package com.example.demo;

import org.quartz.*;

import java.util.Date;

/**
 * description
 *
 * @author zb 2019/04/03 14:51
 */
public class MyJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        /**
         * JobExecutionContext 能做什么
         */

        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        jobDetail.getJobDataMap().get("message");
        Trigger trigger = jobExecutionContext.getTrigger();
        trigger.getJobDataMap().get("message");


        System.out.println("复杂的任务正在疯狂的执行中。。。。"+new Date().toString());
    }
}
