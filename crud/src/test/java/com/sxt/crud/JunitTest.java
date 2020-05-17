package com.sxt.crud;

import com.sxt.crud.mapper.UserMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author ouyangjie
 * @createTime 2019-12-08 11:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CrudApplicationTests.class)
public class JunitTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser(){
        //userMapper.insertUser(new User("xiaoou2",22,true,"2313968604@qq.com"));
    userMapper.findAll();
        System.out.println(userMapper.findAll());
    }
}
