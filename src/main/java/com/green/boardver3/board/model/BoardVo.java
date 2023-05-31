package com.green.boardver3.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardVo {
    private int iboard;
    private String title;
    private String createdAt;
    private String iuser;
    private String writerMainPic;
}
