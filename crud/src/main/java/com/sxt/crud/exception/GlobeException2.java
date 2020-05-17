package com.sxt.crud.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ouyangjie
 * @createTime 2019-12-08 9:25
 */
//最好用
@Configuration
public class GlobeException2 implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        if(ex instanceof ArithmeticException){
            mv.setViewName("error1");
        }
        if(ex instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",ex.toString());
       return mv;
    }
}
