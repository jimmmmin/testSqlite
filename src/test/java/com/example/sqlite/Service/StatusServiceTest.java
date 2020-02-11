package com.example.sqlite.Service;

import com.example.sqlite.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusServiceTest {
    @Autowired
    StatusService statusService;

    @Test
    public void getStatus(){
        Status status = statusService.getStatus();
        log.info("status : {}", status.toString());
    }

    @Test
    public void addStatus() {
        statusService.addStatus(new Status("leelee", 5000, 20));
        log.info("넣기 성공");
    }

}
