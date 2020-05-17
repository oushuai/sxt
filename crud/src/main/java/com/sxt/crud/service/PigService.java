package com.sxt.crud.service;

import com.sxt.crud.pojo.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author ouyangjie
 * @createTime 2019-12-01 21:45
 */
public interface PigService {
    void addPig(Pig pig);

    List<Pig> findALL();

    Optional<Pig> findPigById(Integer id);

    void updatePig(Pig pig);

    void deletePigById(Integer id);

    Page<Pig> findPigByPage(Pageable pageable);
}

