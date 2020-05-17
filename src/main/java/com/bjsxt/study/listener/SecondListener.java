package com.bjsxt.study.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ouyangjie
 * @createTime 2019-11-24 18:59
 */
@WebListener
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Secondlistener starts to work!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
