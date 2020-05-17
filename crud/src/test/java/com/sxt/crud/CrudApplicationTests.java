package com.sxt.crud;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication
@MapperScan("com.sxt.crud.mapper")
class CrudApplicationTests {

    @Test
    void contextLoads() {
    }

}
