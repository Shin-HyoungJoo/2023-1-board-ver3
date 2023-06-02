package com.green.boardver3.cmt.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CmtRes {
    private int maxPage;
    private int row;
    private int isMore; // 0이면 댓글 더 없음, 1이면 댓글 더 있음
    private List<CmtVo> list;

}
