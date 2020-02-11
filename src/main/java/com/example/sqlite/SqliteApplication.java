package com.example.sqlite;

import com.example.sqlite.Service.StatusService;
import com.example.sqlite.model.BufferStatus;
import com.example.sqlite.model.ImmediateStatus;
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
    StatusService statusService;


    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hihi");

        //buffer INSERT
        List<String> bstconfig = new ArrayList<>();
        bstconfig.add("223.194.70.105:19590");
        bstconfig.add("223.194.70.105:19690");
        bstconfig.add("223.194.70.105:19790");

        List<String> buftopicname = new ArrayList<>();
        buftopicname.add("newbuffertopic");

        statusService.addBufferStatus(new BufferStatus(bstconfig,false,"Lee0",buftopicname,10,false,5000,1000));

        //buffer SELECT
        List<BufferStatus> bufferStatusList = statusService.getBufferStatus();
        log.info("status : {}", bufferStatusList);


        //immediate INSERT
        List<String> immtopicname = new ArrayList<>();
        immtopicname.add("newimmediatetopic");

        statusService.addImmediateStatus(new ImmediateStatus(bstconfig,false,"Lee",immtopicname,true,5000,1000));

        //immediate SELECT
        List<ImmediateStatus> immediateStatusList = statusService.getImmediateStatus();
        log.info("status : {}", immediateStatusList);
    }



}
