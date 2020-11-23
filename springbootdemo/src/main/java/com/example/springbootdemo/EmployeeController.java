package com.example.springbootdemo;

import com.example.springbootdemo.bean.Employee;
import com.example.springbootdemo.enums.RabbitMQNums;
import com.example.springbootdemo.service.EmployeeService;
import com.example.springbootdemo.utils.RabbitMQUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private EmployeeService service;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQUtils utils;


    @GetMapping("/emp/{id}")
    public Object getEmployeeById(@PathVariable String id){
        return service.getEmployeeById(id);

    }

    @GetMapping("/redis/{id}")
    public Object setEmployeeById(@PathVariable String id){
        System.out.println("进行缓存....");

        Employee o = (Employee)redisTemplate.opsForValue().get(id);
        if(o != null){
            return o;
        }else{
            Employee emp = service.setEmployeeById(id);
            redisTemplate.opsForValue().set(emp.getId(),emp);
            return emp;
        }


    }

    @GetMapping("/sendMessage/{id}")
    public Object sendMessage(@PathVariable String id){

        logger.info("消息开始发送至中间件：{}",id);

        Employee employee = service.getEmployeeById(id);


        utils.createBinding(RabbitMQNums.QUEUE_ATGUIGU_NEWS,RabbitMQNums.EXCHANGE_DIRECT,RabbitMQNums.ROUTE_KEY_1);

        rabbitTemplate.convertAndSend(RabbitMQNums.EXCHANGE_DIRECT,RabbitMQNums.ROUTE_KEY_1,employee);

        logger.info("消息发送成功：",id);

        return "OK";

    }




}
