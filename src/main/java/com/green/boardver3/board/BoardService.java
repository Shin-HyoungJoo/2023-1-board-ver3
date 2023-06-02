package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.cmt.CmtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoardService {
    private final BoardMapper mapper;
    private final CmtMapper cmtMapper;  //CmtMapper 주소값 얻는 용도

    @Autowired
    public BoardService(BoardMapper mapper, CmtMapper cmtMapper) {
        this.mapper = mapper;
        this.cmtMapper = cmtMapper;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result = mapper.insBoard(entity);
        if(result == 1) {
            return entity.getIboard();
        }
        return result;
    }

    public List<BoardVo> selBoard(BoardDto dto) {
        int ROW_PER_PAGE = dto.getRow();
        dto.setStartIdx((dto.getPage() - 1) * ROW_PER_PAGE);
        dto.setRowLen(ROW_PER_PAGE);
        return mapper.selBoard(dto);
    }
    public int selMaxBoard(int row) {
        int count = mapper.selMaxBoard(row);
        return (int)Math.ceil((double) count / row);
    }

    public BoardDetailVo selBoardDetail(BoardDto dto) {
        return mapper.selBoardDetail(dto);
    }

    public int delBoard(BoardDelDto dto) {
        int result = cmtMapper.delBoardCmt(??);
        return mapper.delBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }
}
