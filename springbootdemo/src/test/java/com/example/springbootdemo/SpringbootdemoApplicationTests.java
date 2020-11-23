package com.example.springbootdemo;

import com.example.springbootdemo.bean.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private EmployeeService service;

    @Test
    void contextLoads() {
    }

    @Test
    public void test01(){
        System.out.println("进行缓存....");
        Employee emp = service.getEmployeeById("1");
        redisTemplate.opsForList().leftPush(emp.getId(),emp);
    }


}
