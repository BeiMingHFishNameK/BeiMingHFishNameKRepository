package com.example.springbootdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQUtils {

    private static Logger logger = LoggerFactory.getLogger(RabbitMQUtils.class);

    @Autowired
     AmqpAdmin amqpAdmin;

    public DirectExchange createDirectExchange(String name){
        logger.info("创建交换机：{}",name);
        DirectExchange exchange = new DirectExchange(name);
        amqpAdmin.declareExchange(exchange);
        return exchange;
    }

    public Queue createQueue(String name){
        logger.info("创建队列：{}",name);
        Queue queue = new Queue(name);
        amqpAdmin.declareQueue(queue);
        return queue;
    }

    public void createBinding(String queueName,String exchangeName,String routeKey){
        Binding binding = BindingBuilder.bind(createQueue(queueName)).to(createDirectExchange(exchangeName)).with(routeKey);
        logger.info("绑定交换机与队列");
        amqpAdmin.declareBinding(binding);
    }




}
