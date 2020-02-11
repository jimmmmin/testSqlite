package com.example.sqlite.Service;

import com.example.sqlite.model.Status;
import com.example.sqlite.Mapper.ExampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusService {

    @Autowired
    ExampleMapper exampleMapper;

    public Status getStatus(){
        return exampleMapper.selectStatus();
    }

    public void addStatus(Status status) {
        exampleMapper.insertStatus(status);
    }

}
