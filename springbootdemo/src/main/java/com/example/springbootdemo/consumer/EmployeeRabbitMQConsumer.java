package com.example.springbootdemo.consumer;

import com.example.springbootdemo.bean.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "atguigu.news")
public class EmployeeRabbitMQConsumer {

    @RabbitHandler
    public void process(Employee employee){
        System.out.println("EmployeeRabbitMQConsumer消费者收到消息  : " + employee.toString());
    }

}
