package com.green.boardver3;

import com.green.boardver3.model.Boardver3InsDto;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Boardver3Service {
    private final Boardver3Mapper mapper;
    private final CommonUtils commonUtils;

    @Autowired
    public Boardver3Service(Boardver3Mapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int insBoard(Boardver3InsDto dto) {
        String hashPw = commonUtils.encodeSha256(dto.getPw());
        dto.setPw(hashPw);
        return mapper.insBoard(dto);
    }
}
