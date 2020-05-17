package com.sxt.crud.repository;

import com.sxt.crud.pojo.Pig;
import org.springframework.data.repository.PagingAndSortingRepository;
//只能对所有数据查询排序处理
public interface PigRepositoryPagingandSortingRepository extends PagingAndSortingRepository<Pig,Integer> {

}
