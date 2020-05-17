package com.bjsxt.study.controller;

import com.bjsxt.study.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**SpringBoot整合jsp
 * @author ouyangjie
 * @createTime 2019-11-25 10:04
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/list")
    public String show(Model model) {
        List<User> list=new ArrayList<>();
        list.add(new User(1L,"Oushuai",22,true));
        list.add(new User(2L,"Wudi",28,true));
        list.add(new User(3L,"Tonghua",7,false));
        list.add(new User(4L,"Xiaohei",14,false));
        model.addAttribute("list",list);
        return "index";
    }
}
