package com.example.sqlite.Config;

import com.example.sqlite.SqliteApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackageClasses = SqliteApplication.class)
public class DataSourceConfig {

}