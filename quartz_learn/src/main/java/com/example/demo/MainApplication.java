package com.example.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * description
 *
 * @author zb 2019/04/03 14:51
 */
public class MainApplication {
    public static void main(String[] args) {
        // try {
        //     //jobDetail
        //     JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("cronJob")
        //             .usingJobData("message","jobdetail message")
        //             .build();
        //     //cronTrigger
        //     //每日的9点40触发任务
        //     //1.每日10点15分触发      0 15 10 ？* *
        //     //2.每天下午的2点到2点59分（正点开始，隔5分触发）       0 0/5 14 * * ?
        //     //3.从周一到周五每天的上午10点15触发      0 15 10 ? MON-FRI
        //     //4.每月的第三周的星期五上午10点15触发     0 15 10 ? * 6#3
        //     //5.2016到2017年每月最后一周的星期五的10点15分触发   0 15 10 ? * 6L 2016-2017
        //     /*CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        //             .withIdentity("cronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 40 9 * * ? ")).build();*/
        //     SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger")
        //             .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
        //                     .withIntervalInSeconds(5).repeatForever())
        //             .usingJobData("message","trigger message")
        //             .build();
        //
        //     //Scheduler实例
        //     StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        //     Scheduler scheduler = stdSchedulerFactory.getScheduler();
        //     scheduler.start();
        //     scheduler.scheduleJob(jobDetail,trigger);
        // } catch (SchedulerException e) {
        //     e.printStackTrace();
        // }

       Date date = new Date();
       String str = "00:00:00";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(dateFormat(date,str));
    }


    private static Date dateFormat(Date date,String str) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime1 = instant.atZone(zoneId).toLocalDateTime();
        String dateStr = localDateTime1.format(formatter);
        dateStr = dateStr+" "+str;

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateStr,formatter);

        ZoneId zoneId1 = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime2.atZone(zoneId1);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date1 = Date.from(zdt.toInstant());
        return date1;
    }
}
