package com.sxt.crud.controller;

import com.sxt.crud.pojo.User;
import com.sxt.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 22:05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/add")
    public String addUser(User user){
            return "add";
    }
    @RequestMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        userService.addUser(user);
        return "redirect:/user/list";
    }
    @RequestMapping("/list")
    public String findUserAll(Model model){
        List<User> list=userService.findALL();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/get/{id}")
    public String getUserById(@PathVariable Integer id, Model model){
        User user=userService.findUserById(id);
        model.addAttribute("user",user);
        return "get";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){
       userService.updateUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id,Model model){
        User user=userService.findUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "ok";
    }

    public static void main(String[] args) {
        try {
            System.out.println(URLDecoder.decode("%7Buser.id%7D","utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
