package com.bjsxt.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ouyangjie
 * @createTime 2019-11-24 17:24
 * <filter>
 *     <filter-name>FirstFilter</filter-name>
 *     <filter-class>com.bjsxt.study.FirstFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *      <filter-name>FirstFilter</filter-name>
 *     <url-patten>/first</url-patten>
 * </filter-mapping>
 */
//@WebFilter(filterName = "FirstFilter",urlPatterns = "{*.do,*.jsp}")
@WebFilter(filterName = "FirstFilter",urlPatterns = "/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开Filter");
    }
}
