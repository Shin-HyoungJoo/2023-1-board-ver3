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
//        CmtIEntity entity = new CmtIEntity();
        entity.setCtnt(entity.getCtnt());
        entity.setIboardCmt(entity.getIboardCmt());
        entity.setIuser(entity.getIuser());
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

    public List<CmtVo> selBoardCmt(CmtDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selCmt(dto);
    }

    public int delCmt(CmtDelDto dto) {
        return mapper.delCmt(dto);
    }

    public int updCmt (CmtUpdDto dto) {

        return mapper.updCmt(dto);
    }

    /*public List<CmtVo> selCmt(CmtDto dto) {
        int ROW_PER_PAGE = dto.getRow();
        dto.setRow(ROW_PER_PAGE);
        dto.setStartIdx((dto.getPage()-1)*ROW_PER_PAGE);
        return mapper.selCmt(dto);
    }*/
}
