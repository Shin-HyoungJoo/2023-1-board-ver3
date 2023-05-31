package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtIEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insCmt (CmtIEntity dto);
}
