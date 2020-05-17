package com.bjsxt.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangjie
 * @createTime 2019-11-24 15:37
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public Map<String, Object> helloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "helloworld");
        return map;
    }
    @RequestMapping("/uploadController")
    public String upload(MultipartFile fileName){
        System.out.println(fileName.getOriginalFilename());
        System.out.println(fileName.getSize());
        try {
            fileName.transferTo(new File("E:\\"+fileName.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
