package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public List<BoardVo> selBoard(BoardDto dto) {
        int ROW_PER_PAGE = dto.getRow();
        dto.setStartIdx((dto.getPage() - 1) * ROW_PER_PAGE);
        dto.setRowLen(ROW_PER_PAGE);
        return mapper.selBoard(dto);
    }
    public int selMaxBoard(int row) {
        return mapper.selMaxBoard(row);
    }
}
