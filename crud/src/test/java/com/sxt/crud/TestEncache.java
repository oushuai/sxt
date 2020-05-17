package com.sxt.crud;

import com.sxt.crud.pojo.Pig;
import com.sxt.crud.service.PigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ouyangjie
 * @createTime 2019-12-14 17:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestEncache {
    @Autowired
    private PigService pigService;
    @Test
    public void testFindPigById(){
        System.out.println(pigService.findPigById(1).get());
        System.out.println(pigService.findPigById(1).get());
    }

    @Test
    public void testFindPigByPage(){
        Pageable pageable= PageRequest.of(0,2);
        System.out.println(pigService.findPigByPage(pageable).getTotalElements());
        System.out.println(pigService.findPigByPage(pageable).getTotalElements());
        Pageable pageable1= PageRequest.of(1,2);
        System.out.println(pigService.findPigByPage(pageable1).getTotalElements());
    }

    @Test
    public void testFindAll(){
        System.out.println(pigService.findALL().size());
        Pig pig=new Pig();
        pig.setAge(23);
        pig.setName("test");
        pigService.addPig(pig);
        System.out.println(pigService.findALL().size());

    }
}
