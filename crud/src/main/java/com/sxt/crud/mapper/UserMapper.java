package com.sxt.crud.mapper;

import com.sxt.crud.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:23
 */
@Mapper
public interface UserMapper {
    void insertUser(User user);

    List<User> findAll();

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
