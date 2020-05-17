package com.sxt.crud;

import com.sxt.crud.pojo.Pig;
import com.sxt.crud.repository.PigCRUDRepository;
import com.sxt.crud.repository.PigRepository;
import com.sxt.crud.repository.PigRepositoryPagingandSortingRepository;
import com.sxt.crud.repository.PigRepositorySpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2019-12-10 19:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestRespository {
    @Autowired
    private PigRepository pigRepository;
    @Autowired
    private PigCRUDRepository pigcrudRepository;
    @Autowired
    private PigRepositoryPagingandSortingRepository pigRepositoryPagingandSortingRepository;
    @Autowired
    private PigRepositorySpecification pigRepositorySpecification;

    @Test
    public void testSave() {
        Pig pig = new Pig("wudi", "死ju", false, 28);
        pigRepository.save(pig);
    }

    @Test
    public void testFindByFolkName() {
        List<Pig> pigList = pigRepository.findByFolkName("死ju");
        Iterator<Pig> iterator = pigList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testFindByFolkNameLike() {
        List<Pig> pigList = pigRepository.findByFolkNameLike("%" + "ju" + "%");
        Iterator<Pig> iterator = pigList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryByFolkName() {
        List<Pig> pigList = pigRepository.queryByFolkNameHQL("死ju");
        Iterator<Pig> iterator = pigList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testupdatePigFolkNameById() {
        //这个修改方便点
        pigRepository.updatePigFolkNameById("臭屁ju", 2);
    }

    //注意crud的save方法包括保存和更新
    @Test
    public void testCRUDPigC() {
        pigcrudRepository.save(new Pig("xiaoou", "xiaoxiangju", true, 22));
    }

    @Test
    public void testCRUDPigU() {
        Pig pig = new Pig("xiaoou", "小香ju", true, 22);
        pig.setId(3);
        //这个修改实体类所有属性都要赋值，不然为null
        pigcrudRepository.save(pig);
    }

    @Test
    public void testCRUDPigD() {
        pigcrudRepository.deleteById(4);
    }

    @Test
    public void testSorting() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        List<Sort.Order> list = new ArrayList<>();
        list.add(order);
        //下面这个不同了哦
        Sort sort = Sort.by(list);
//        List<Pig> pigList=new ArrayList<>();
//        Iterator<Pig> iterator=pigList.iterator();
        Iterator<Pig> iterator = pigRepositoryPagingandSortingRepository.findAll(sort).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    //Iterable只是一个接口，但是可以强转为List
    //jpaRepository做了处理，就可以不要强转
    @Test
    public void testSorting1() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        List<Sort.Order> list = new ArrayList<>();
        list.add(order);
        //下面这个不同了哦
        Sort sort = Sort.by(list);
        List<Pig> pigList = (List<Pig>)pigRepositoryPagingandSortingRepository.findAll(sort);
        Iterator<Pig> iterator=pigList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //排序加分页PageRequest.of里面重载
    @Test
    public void testPaging() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        List<Sort.Order> list = new ArrayList<>();
        list.add(order);
        Sort sort = Sort.by(list);
        //page当前页从0开始
        int currentPage = 1;
        int size = 2;
        //下面这个不同了哦
        Pageable pageable = PageRequest.of(currentPage, size, sort);
        Page<Pig> page = pigRepositoryPagingandSortingRepository.findAll(pageable);
        System.out.println("总条数" + page.getTotalElements());
        System.out.println("总页数" + page.getTotalPages());
        List<Pig> pigList = page.getContent();
        for (Pig pig : pigList) {
            System.out.println(pig);
        }
    }
    //单条件查询
    @Test
    public void testJpaSpecificationExcutor() {
        Specification<Pig> specification=new Specification<Pig>() {
            //Predicate:封装单个查询条件
            @Override
            public Predicate toPredicate(Root<Pig> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               //where name="xiaoou"
                //equal(查询属性，条件的值)
                Predicate predicate=criteriaBuilder.equal(root.get("name"),"xiaoou");
                return predicate;
            }
        };
        List<Pig> pigList =pigRepositorySpecification.findAll(specification);
        for (Pig pig : pigList) {
            System.out.println(pig);
        }
    }

    //多条件查询
    @Test
    public void testJpaSpecificationExcutor1() {
        Specification<Pig> specification=new Specification<Pig>() {
            //Predicate:封装单个查询条件
            @Override
            public Predicate toPredicate(Root<Pig> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //where name="xiaoou" and age=22
                //equal(查询属性，条件的值)
                List<Predicate> predicates=new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("name"),"xiaoou"));
                predicates.add(criteriaBuilder.equal(root.get("age"),22));
                Predicate[] predicateArray=new Predicate[predicates.size()];
               // return criteriaBuilder.and(predicates.toArray(predicateArray));
                return criteriaBuilder.and(criteriaBuilder.equal(root.get("age"),22),criteriaBuilder.equal(root.get("name"),"xiaoou"));
            }
        };
        List<Pig> pigList =pigRepositorySpecification.findAll(specification);
        for (Pig pig : pigList) {
            System.out.println(pig);
        }
    }

    //多条件查询
    @Test
    public void testJpaSpecificationExcutor2() {
        Specification<Pig> specification=new Specification<Pig>() {
            //Predicate:封装单个查询条件
            @Override
            public Predicate toPredicate(Root<Pig> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //where name="xiaoou" or age=22
                //equal(查询属性，条件的值)
                List<Predicate> predicates=new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("name"),"xiaoou"));
                predicates.add(criteriaBuilder.equal(root.get("age"),22));
                Predicate[] predicateArray=new Predicate[predicates.size()];
                // return criteriaBuilder.and(predicates.toArray(predicateArray));
                return criteriaBuilder.or(criteriaBuilder.equal(root.get("age"),22),criteriaBuilder.equal(root.get("name"),"xiaoou"));
            }
        };
        Sort sort=Sort.by(new Sort.Order(Sort.Direction.DESC,"id"));
        List<Pig> pigList =pigRepositorySpecification.findAll(specification,sort);
        for (Pig pig : pigList) {
            System.out.println(pig);
        }
    }
}
