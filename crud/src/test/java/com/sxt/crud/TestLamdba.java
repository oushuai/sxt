package com.sxt.crud;

import java.util.Arrays;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-31 9:07
 */
public class TestLamdba {
    public static void main(String[] args) {
        List<String> ages= Arrays.asList("11","23","28");
        ages.forEach(System.out::println);
    }
}
