package com.bjsxt.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**2.通过方法完成Servlet组件的注册，结合APP启动类
 * @author ouyangjie
 * @createTime 2019-11-24 17:01
 */
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MySecondServlet..");
    }
}
