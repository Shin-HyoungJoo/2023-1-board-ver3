package com.green.boardver3.board.model;

import com.green.boardver3.cmt.CmtService;
import com.green.boardver3.cmt.model.CmtRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoardDetailcmtVo {
    private BoardDetailVo boardDetailVo;
    private CmtRes cmt;
}
