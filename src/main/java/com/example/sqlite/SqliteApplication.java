package com.example.sqlite;

import com.example.sqlite.Service.BufferStatusService;
import com.example.sqlite.model.BufferStatus;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@MapperScan(basePackages = "com.example.sqlite")
@SpringBootApplication
public class SqliteApplication implements CommandLineRunner {

    @Autowired
    BufferStatusService bufferStatusService;


    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hihi");
/*
        //INSERT부분
        statusService.addStatus(new Status("leelee", 5000, 20));
        log.info("넣기 성공");

        //SELECT부분
        Status status = statusService.getStatus();
        log.info("status : {}", status.toString());
        }
 */
        //INSERT
        List<String> bfstconfig = new ArrayList<>();
        bfstconfig.add("223.194.70.105:19590");
        bfstconfig.add("223.194.70.105:19690");
        bfstconfig.add("223.194.70.105:19790");

        List<String> topicname = new ArrayList<>();
        topicname.add("newbuffertopic");

        bufferStatusService.addBufferStatus(new BufferStatus(bfstconfig,false,"Lee0",topicname,10,false,5000,1000));

        //SELECT
        List<BufferStatus> bufferStatusList = bufferStatusService.getStatus();
        log.info("status : {}", bufferStatusList);
    }



}
