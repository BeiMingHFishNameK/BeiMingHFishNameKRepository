package com.example.springbootdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
