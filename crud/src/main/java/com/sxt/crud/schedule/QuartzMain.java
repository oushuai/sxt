package com.sxt.crud.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author ouyangjie
 * @createTime 2019-12-16 19:15
 */
public class QuartzMain {
    public static void main(String[] args) {
        //1.创建Job对象，要做什么
        //2.创建Trigger对象，什么时间做
        /*
    (1)简单的Trigger触发
    （2）cron表达式触发

        * */
        //3.创建Schedule对象，什么时间做什么
        JobDetail job= JobBuilder.newJob(QuartzDemo.class).build();
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatHourlyForever(2)).build();
        try {
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
