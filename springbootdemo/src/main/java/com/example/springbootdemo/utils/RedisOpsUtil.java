package com.example.springbootdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisOpsUtil {

    @Autowired
    private static RedisTemplate<Object,Object> redisTemplate;

    public static void setValue(Object key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public static Object getValue(Object key){
        return redisTemplate.opsForValue().get(key);
    }

}
