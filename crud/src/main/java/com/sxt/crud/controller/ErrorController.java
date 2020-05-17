package com.sxt.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ouyangjie
 * @createTime 2019-12-07 16:02
 */
@Controller
public class ErrorController {
    @RequestMapping("/show")
    public String show() {
        String s = null;
        s.length();
        return "ok";
    }

    @RequestMapping("/show1")
    public String show1() {
        int a = 10 / 0;
        return "ok";
    }


}
