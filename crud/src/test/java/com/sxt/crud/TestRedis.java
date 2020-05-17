package com.sxt.crud;

import com.sxt.crud.config.RedisUtils;
import com.sxt.crud.pojo.Role;
import com.sxt.crud.pojo.User;
import com.sxt.crud.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ouyangjie
 * @createTime 2019-12-15 12:33
 */
//redisTemplate好用
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestRedis {
    @Autowired
    private RedisService redisService ;
    @Autowired
    private RedisUtils redisUtils ;
    @Autowired
    @Qualifier("template")
    private RedisTemplate redisTemplate;
    @Test
    public  void test(){
        System.out.println(redisService.get("abcd"));
        redisService.set("aaaa","1111");
        System.out.println(redisService.exists("bb"));
        System.out.println(redisService.get("aaaa"));
    }
    @Test
    public  void test1(){
        System.out.println(redisUtils.get("aaa"));
        redisUtils.set("abcd","1111");
        redisUtils.set("cd","2333");
        redisUtils.set("ef","1233");
        System.out.println(redisUtils.get("cd"));
        System.out.println(redisUtils.get("ef"));
        redisUtils.expire("ef",3600L);
        System.out.println(redisUtils.ttl("ef"));
    }
    @Test
    public  void test2(){
        redisTemplate.opsForValue().set("cd","333");
        System.out.println(redisTemplate.opsForValue().get("cd"));
        User user=new User("test",22,true,"",new Role("懒ju","打游戏"));

        redisTemplate.opsForValue().set("wudi",user);
        System.out.println((redisTemplate.opsForValue().get("wudi")));
    }
    //json格式存储对象
    @Test
    public  void testSetJson(){
        User user=new User("test",22,true,"",new Role("懒ju","打游戏"));
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        redisTemplate.opsForValue().set("user_json",user);

    }
    //json格式获取对象
    @Test
    public  void testGetJson(){
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user=(User) redisTemplate.opsForValue().get("user_json");
        System.out.println(user);
    }
}
