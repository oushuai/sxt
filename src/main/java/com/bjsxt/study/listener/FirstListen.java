package com.bjsxt.study.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ouyangjie
 * @createTime 2019-11-24 18:59
 */
@WebListener
public class FirstListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listen starts to work!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public static void main(String[] args) {
        try {
           String s= URLEncoder.encode("童话","utf-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
