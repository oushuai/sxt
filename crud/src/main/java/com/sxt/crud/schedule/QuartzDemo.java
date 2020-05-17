package com.sxt.crud.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ouyangjie
 * @createTime 2019-12-16 19:13
 */
public class QuartzDemo implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy MM dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
