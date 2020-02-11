package com.example.sqlite.Mapper;

import com.example.sqlite.model.Status;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleMapper {
    //int selectNumber(@Param("number") int number);
   Status selectStatus();
   void insertStatus(Status status);
}
