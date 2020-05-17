package com.sxt.crud.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ouyangjie
 * @createTime 2019-12-16 14:34
 */
@Component
public class ScheduleDemo {
    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 * * * * ?")
    public void HourTask(){
        System.out.println(new Date());
    }
}
