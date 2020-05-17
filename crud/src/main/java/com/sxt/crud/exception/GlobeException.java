//package com.sxt.crud.exception;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * @author ouyangjie
// * @createTime 2019-12-07 21:05
// */
////这个用的比较多
//@ControllerAdvice
//public class GlobeException {
//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView ArithmeticExceptionHandle(Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error1");
//        return mv;
//    }
//
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView NullPointerExceptionHandle(Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("error", e.toString());
//        mv.setViewName("error2");
//        return mv;
//    }
//}
