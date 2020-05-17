package com.sxt.crud.repository;

import com.sxt.crud.pojo.Pig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ouyangjie
 * @createTime 2019-12-11 18:19
 */
//独立的接口，需要和JpaRepository一起使用
public interface PigRepositorySpecification extends JpaRepository<Pig,Integer>, JpaSpecificationExecutor<Pig> {
}
