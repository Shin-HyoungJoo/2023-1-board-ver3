package com.green.boardver3;


import com.green.boardver3.model.Boardver3InsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Boardver3Mapper {
    int insBoard(Boardver3InsDto dto);
}
