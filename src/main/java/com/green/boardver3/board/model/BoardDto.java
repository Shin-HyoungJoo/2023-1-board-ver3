package com.green.boardver3.board.model;

import lombok.Builder;
import lombok.Data;

@Data
public class BoardDto {
    private int page;
    private int startIdx;
    private int rowLen;
    private int row;
    private int iboard;
}
