package com.bjsxt.study;

import com.bjsxt.study.filter.SecondFilter;
import com.bjsxt.study.listener.SecondListener;
import com.bjsxt.study.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author ouyangjie
 * @createTime 2019-11-24 17:02
 */
//@SpringBootApplication
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return  bean;
    }
    @Bean
    public FilterRegistrationBean getFilterRegistationBean(){
        FilterRegistrationBean bean=new FilterRegistrationBean(new SecondFilter());
     //   bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean=new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }
}
