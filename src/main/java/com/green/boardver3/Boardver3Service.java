package com.green.boardver3;

import com.green.boardver3.model.Boardver3InsDto;
import com.green.boardver3.model.UpdateDto;
import com.green.boardver3.model.UserLoginDto;
import com.green.boardver3.model.UserLoginVo;
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

    public int login(UserLoginDto dto) {
        UserLoginVo vo = mapper.selUserByUid(dto);    //셀렉트 최종값//셀렉트 최종값
        if(vo == null) {
            return 2;
        }
        String hashedPw = commonUtils.encodeSha256(dto.getPw());
        if(vo.getPw().equals(hashedPw)) {
            return 1;
        }
        return 3;
    }

    public int updBoard(UpdateDto dto) {
        return mapper.updBoard(dto);
    }
}
