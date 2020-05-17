package com.bjsxt.study.controller;

import com.bjsxt.study.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author ouyangjie
 * @createTime 2019-11-30 18:31
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("msg", "helloworld");
        return "string";
    }

    @RequestMapping("/show1")
    public String show1(Model model) {
        model.addAttribute("date", new Date());
        return "date";
    }

    @RequestMapping("/show2")
    public String show2(Model model) {
        model.addAttribute("sex", "男");
        model.addAttribute("id", "2");
        return "if";
    }

    @RequestMapping("/show3")
    public String show3(Model model) {
        List<User> list=new ArrayList<>();
        list.add(new User(1L,"Oushuai",22,true));
        list.add(new User(2L,"Wudi",28,true));
        list.add(new User(3L,"Tonghua",7,false));
        list.add(new User(4L,"Xiaohei",14,false));
        model.addAttribute("list",list);
        Map<String,User> map=new HashMap<>();
        map.put("user1",new User(1L,"Oushuai",22,true));
        map.put("user2",new User(2L,"Wudi",28,true));
        map.put("user3",new User(3L,"Tonghua",7,false));
        map.put("user4",new User(4L,"Xiaohei",14,false));
        model.addAttribute("map",map);
        return "userList";
    }

    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page,Integer id) {
        System.out.println(id);
        return page;
    }
}
