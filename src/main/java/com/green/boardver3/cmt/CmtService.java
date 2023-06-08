package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CmtService {
    private final CmtMapper mapper;


    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }


    public int insCmt(CmtIEntity entity) {
        try {
            int result = mapper.insCmt(entity);
            if (result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public CmtRes selBoardCmt(CmtDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        List<CmtVo> list = mapper.selCmt(dto);

        int count = mapper.selCountCmt(dto);
        int maxPage = (int) (Math.ceil((double) count / dto.getRow()));
        int isMore = dto.getPage() >= maxPage ? 0 : 1;

        return CmtRes.builder().row(dto.getRow()).maxPage(maxPage).list(list).isMore(isMore).build();
    }

    public int delCmt(CmtDelDto dto) {
        return mapper.delCmt(dto);
    }

    public int updCmt(CmtIEntity dto) {
        return mapper.updCmt(dto);
    }

    /*public List<CmtVo> selCmt(CmtDto dto) {
        int ROW_PER_PAGE = dto.getRow();
        dto.setRow(ROW_PER_PAGE);
        dto.setStartIdx((dto.getPage()-1)*ROW_PER_PAGE);
        return mapper.selCmt(dto);
    }*/
}
