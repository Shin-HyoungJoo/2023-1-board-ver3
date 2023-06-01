package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtDelDto;
import com.green.boardver3.cmt.model.CmtDto;
import com.green.boardver3.cmt.model.CmtIEntity;
import com.green.boardver3.cmt.model.CmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt (CmtIEntity dto);
    List<CmtVo> selCmt(CmtDto dto);
    int delCmt (CmtDelDto dto);
}
