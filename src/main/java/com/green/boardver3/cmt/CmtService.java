package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtIEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }


    public int insCmt(CmtInsDto dto) {
        CmtIEntity entity = new CmtIEntity();
        entity.setCtnt(entity.getCtnt());
        entity.setIboardCmt(entity.getIboardCmt());
        entity.setIuser(entity.getIuser());
        return mapper.insCmt(entity);
    }
}
