package com.bjsxt.study;

/**
 * @author ouyangjie
 * @createTime 2020-05-07 12:45
 */
public class Test {

        static String finalResult = "";
        public static void main(String... doYourBest){ executeAction(1,true); executeAction(); executeAction(new int[]{1,2,3},1); executeAction(1L); executeAction(1); executeAction(Double.valueOf(1)); System.out.println(finalResult); } static void executeAction(Object o){finalResult+="1";} static void executeAction(Object... o){finalResult+="2";} static void executeAction(StackOverflowError... i){finalResult+="3";} static void executeAction(Long l){finalResult+="4";} static void executeAction(double d){finalResult+="5";}


}
