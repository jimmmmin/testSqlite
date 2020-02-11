package com.example.sqlite.Service;

import com.example.sqlite.Mapper.StatusMapper;
import com.example.sqlite.model.BufferStatus;
import com.example.sqlite.model.ImmediateStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusMapper statusMapper;

    public List<BufferStatus> getBufferStatus(){
        return statusMapper.selectAllBufferStatus();
    }

    public void addBufferStatus(BufferStatus status) {
        statusMapper.insertBufferStatus(status);

    }

    public List<ImmediateStatus> getImmediateStatus(){
        return statusMapper.selectAllImmediateStatus();
    }

    public void addImmediateStatus(ImmediateStatus status) {
        statusMapper.insertImmediateStatus(status);
    }
}
