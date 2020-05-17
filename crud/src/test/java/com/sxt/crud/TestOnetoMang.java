package com.sxt.crud;

import com.sxt.crud.pojo.Role;
import com.sxt.crud.pojo.User;
import com.sxt.crud.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @author ouyangjie
 * @createTime 2019-12-12 16:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestOnetoMang {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSave(){
        Role role=new Role("臭屁猪","放臭屁");
        User user=new User("无敌",28,false,"",role);
        userRepository.save(user);
    }

    @Test
    public void testFind(){
        Optional<User> optional =userRepository.findById(30);
        User user=optional.get();
        Role role=user.getRole();
        System.out.println(role.getName());
    }


}
