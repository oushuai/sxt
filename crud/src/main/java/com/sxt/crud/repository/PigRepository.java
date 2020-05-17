package com.sxt.crud.repository;

import com.sxt.crud.pojo.Pig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-10 19:28
 */
public interface PigRepository extends JpaRepository<Pig,Integer> {
    List<Pig> findByFolkName(String folkName);
    //注意："%"+folkName+"%"
    List<Pig> findByFolkNameLike(String folkName);

    @Query(value = "select id,name,age,sex,folk_name from pig where folk_name = ?1", nativeQuery = true)
    List<Pig> queryByFolkNameHQL(String folkName);

    //注意这种from后面是实体类名字，还有一定是？1
    @Query("from Pig where name = ?1")
    List<Pig> queryByNameUseHQL(String Name);

/*
* 1.更新StockOut表下一些字段， 这里使用了不是原生的sql语句，所以不要加nativeQuery = true。
2.@Transactional 注解用于提交事务，若没有带上这句，会报事务异常提示。
3..@Modifying(clearAutomatically = true) 自动清除实体里保存的数据。
* */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pig set folkName=?1 where id=?2")
    void updatePigFolkNameById(String folkName,Integer id);
}
