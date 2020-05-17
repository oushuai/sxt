package com.sxt.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ouyangjie
 * @createTime 2019-12-16 17:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestSchedule {
    @Test
    public void testScheduled() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String cron = "0 */30 * * * ?"; //每个30分钟执行一次

        if (CronSequenceGenerator.isValidExpression(cron)) {
            System.out.println("表达式正确");
            CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);

            Date currentTime = new Date();
            System.out.println("currentTime: " + sdf.format(currentTime));

            Date nextTimePoint = cronSequenceGenerator.next(currentTime); // currentTime为计算下次时间点的开始时间
            System.out.println("nextTimePoint: " + sdf.format(nextTimePoint));

            Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);
            System.out.println("nextNextTimePoint: " + sdf.format(nextNextTimePoint));


        } else {
            System.out.println("表达式错误");
        }


    }
}
