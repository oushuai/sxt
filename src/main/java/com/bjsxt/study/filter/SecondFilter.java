package com.bjsxt.study.filter;

import javax.servlet.*;
import java.io.IOException;

/**2.通过方法完成Servlet组件的注册，结合APP启动类
 * @author ouyangjie
 * @createTime 2019-11-24 17:01
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入SecondFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开SecondFilter");
    }
}
