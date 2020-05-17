package com.sxt.crud.service.impl;

import com.sxt.crud.pojo.Pig;
import com.sxt.crud.repository.PigRepository;
import com.sxt.crud.service.PigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:46
 */
@Service
public class PigServiceImpl implements PigService {
    @Autowired
    private PigRepository pigRRepository;

    @Override
    @CacheEvict(value = "pig",allEntries = true)
    public void addPig(Pig pig) {
        pigRRepository.save(pig);
         int id=pig.getId();
        System.out.println("#主键是：" +id);
    }

    @Override
    @Cacheable(value = "pig")
    public List<Pig> findALL() {
        return pigRRepository.findAll();
    }

    @Override
    @Cacheable(value = "pig")
    //对当前查询的对象做缓存处理
    public  Optional<Pig> findPigById(Integer id) {
        return pigRRepository.findById(id);
    }

    @Override
    public void updatePig(Pig pig) {
         pigRRepository.save(pig);
    }

    @Override
    public void deletePigById(Integer id) {
        pigRRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "pig",key = "#pageable.pageSize")
    public Page<Pig> findPigByPage(Pageable pageable) {
       return pigRRepository.findAll(pageable);
    }
}
