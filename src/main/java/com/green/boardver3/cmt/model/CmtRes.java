package com.green.boardver3.cmt.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CmtRes {   //댓글출력(list)+기타 정보 담기위한 클래스, dto상위호환
    private int maxPage;
    private int row;
    private int isMore; // 0이면 댓글 더 없음, 1이면 댓글 더 있음
    private List<CmtVo> list;   //댓글출력용 리스트

}
