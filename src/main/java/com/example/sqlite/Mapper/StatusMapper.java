package com.example.sqlite.Mapper;

import com.example.sqlite.model.BufferStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatusMapper {
    List<BufferStatus> selectAllBufferStatus();
    void insertBufferStatus(BufferStatus status);

}
