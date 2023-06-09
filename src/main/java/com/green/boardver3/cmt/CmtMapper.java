package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardDelDto;
import com.green.boardver3.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt (CmtIEntity dto);
    List<CmtVo> selCmt(CmtDto dto);
    int delCmt (CmtDelDto dto);
    int updCmt (CmtIEntity dto);
    int selCountCmt (CmtDto dto);
}
