package com.sxt.crud.repository;

import com.sxt.crud.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ouyangjie
 * @createTime 2019-12-12 16:44
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    //User findById(Integer id);

    @Override
    void deleteById(Integer id);

}
