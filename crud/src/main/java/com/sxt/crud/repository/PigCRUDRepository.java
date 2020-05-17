package com.sxt.crud.repository;

import com.sxt.crud.pojo.Pig;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ouyangjie
 * @createTime 2019-12-11 13:12
 */
public interface PigCRUDRepository extends CrudRepository<Pig,Integer> {
    @Override
    Pig save(Pig pig);
    @Override
    Iterable<Pig> findAll();
    @Override
    void deleteById(Integer id);

}
