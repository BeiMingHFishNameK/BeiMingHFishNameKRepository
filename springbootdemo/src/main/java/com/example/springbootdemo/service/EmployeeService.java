package com.example.springbootdemo.service;

import com.example.springbootdemo.EmployeeController;
import com.example.springbootdemo.bean.Employee;
import com.example.springbootdemo.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeMapper mapper;

    @Cacheable(cacheNames = "emp",key = "#id")
    public Employee getEmployeeById(String id){
        logger.info("查询员工ID{}",id);
        return mapper.getEmployeeById(id);
    }

    public Employee setEmployeeById(String id){
        logger.info("设置员工缓存ID：{}",id);
        return mapper.getEmployeeById(id);
    }
}
