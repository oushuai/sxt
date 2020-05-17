package com.bjsxt.study.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**SpringBoot整合Servlet
 * 1.通过注解扫描完成Servlet组件的注册
 * @author ouyangjie
 * @createTime 2019-11-24 16:03
 * <servlet>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <servlet-class>com.bjsxt.study.FirstServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *      <servlet-name>FirstServlet</servlet-name>
 *     <url-patten>/first</url-patten>
 * </servlet-mapping>
 *
 */
//first改成login
@WebServlet(name = "/login",urlPatterns = "/login")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static long pageView=0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("FirstServlet");
//        RequestDispatcher dispatcher=request.getRequestDispatcher("/login");
//        dispatcher.forward(request,response);
      // doPost(request,response);
        pageView++;
        System.out.println(pageView);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        RequestDispatcher dispatcher=request.getRequestDispatcher("/success.jsp");
        RequestDispatcher dispatcher1=request.getRequestDispatcher("/fail.jsp");
        if(username!=null&&username.equals("oushuai")&&password!=null&&password.equals("123")){
            System.out.println("登录成功！");
            dispatcher.forward(request,response);
        }else{
            System.out.println("登录失败");
            dispatcher1.forward(request,response);
        }
    }
}
