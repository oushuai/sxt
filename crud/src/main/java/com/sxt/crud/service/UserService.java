package com.sxt.crud.service;

import com.sxt.crud.pojo.User;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:45
 */
public interface UserService{
    void addUser(User user);

    List<User> findALL();

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}

