package com.sxt.crud.service.impl;

import com.sxt.crud.mapper.UserMapper;
import com.sxt.crud.pojo.User;
import com.sxt.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:46
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
         int id=user.getId();
        System.out.println("#主键是：" +id);
    }

    @Override
    public List<User> findALL() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
         userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }
}
