//package com.sxt.crud.exception;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.Properties;
//
///**
// * @author ouyangjie
// * @createTime 2019-12-08 9:25
// */
////优点是异常类型和试图的映射，缺点是不能在页面显示异常
//@Configuration
//public class GlobeException1 {
//    @Bean
//    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
//        Properties mapping=new Properties();
//        mapping.put("java.lang.ArithmeticException","error1");
//        mapping.put("java.lang.NullPointerException","error2");
//        resolver.setExceptionMappings(mapping);
//        return resolver;
//    }
//}
