package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtDto;
import com.green.boardver3.cmt.model.CmtIEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtVo;
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

    /*public List<CmtVo> selCmt(CmtDto dto) {
        int ROW_PER_PAGE = dto.getRow();
        dto.setRow(ROW_PER_PAGE);
        dto.setStartIdx((dto.getPage()-1)*ROW_PER_PAGE);
        return mapper.selCmt(dto);
    }*/
}
