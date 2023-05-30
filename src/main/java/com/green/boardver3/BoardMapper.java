package com.green.boardver3;

import com.green.boardver3.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);

}
