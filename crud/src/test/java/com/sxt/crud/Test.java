package com.sxt.crud;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-30 8:33
 */
public class Test {
    public static void main(String[] args) {
        String s="a,bcd,efg";
        String s1[]=s.split(",");
        for(String t:s1){
            System.out.println(t);
        }
        String a[]=new String[3];

        List<String> list=new ArrayList<>();
        list.add("a");
        add(list);
        System.out.println(list);
    }
    public static void add(List<String> list){
        list.add("b");
        System.out.println(list+" add method");
    }
}
