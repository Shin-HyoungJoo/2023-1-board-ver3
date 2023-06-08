package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity dto);
    List<BoardVo> selBoard(BoardDto dto);
    int selBoardRowCount();
    int delBoard(BoardDelDto dto);
    int updBoard(BoardUpdDto dto);
    BoardDetailVo selBoardDetail(BoardDto dto);

}
