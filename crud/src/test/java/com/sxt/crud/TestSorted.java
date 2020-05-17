package com.sxt.crud;

import java.util.*;

/**
 * @author ouyangjie
 * @createTime 2020-04-08 8:58
 */
public class TestSorted implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }

    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        set.add("15");
        set.add("13");
        set.add("14");
        set.add("14");
        Object[] array = set.toArray();
        Arrays.sort(array);
        Arrays.asList(array).forEach(System.out::println);


    }
}
