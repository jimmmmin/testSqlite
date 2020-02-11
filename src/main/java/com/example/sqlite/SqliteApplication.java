package com.example.sqlite;

import com.example.sqlite.Service.StatusService;
import com.example.sqlite.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan(basePackages = "com.example.sqlite")
@SpringBootApplication
public class SqliteApplication implements CommandLineRunner {
    @Autowired
    StatusService statusService;

    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hihi");

        //INSERT부분
        statusService.addStatus(new Status("leelee", 5000, 20));
        log.info("넣기 성공");

        //SELECT부분
        Status status = statusService.getStatus();
        log.info("status : {}", status.toString());
    }


}
