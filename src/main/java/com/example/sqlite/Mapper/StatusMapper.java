package com.example.sqlite.Mapper;

import com.example.sqlite.model.BufferStatus;
import com.example.sqlite.model.ImmediateStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatusMapper {
    List<BufferStatus> selectAllBufferStatus();
    void insertBufferStatus(BufferStatus status);

    List<ImmediateStatus> selectAllImmediateStatus();
    void insertImmediateStatus(ImmediateStatus status);
}
