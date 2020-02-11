package com.example.sqlite.Service;

import com.example.sqlite.Mapper.StatusMapper;
import com.example.sqlite.model.BufferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BufferStatusService {

    @Autowired
    StatusMapper statusMapper;

    public List<BufferStatus> getStatus(){
        return statusMapper.selectAllBufferStatus();
    }

    public void addBufferStatus(BufferStatus status) {
        statusMapper.insertBufferStatus(status);

    }

}
