package com.green.boardver3;


import com.green.boardver3.model.Boardver3InsDto;
import com.green.boardver3.model.UpdateDto;
import com.green.boardver3.model.UserLoginDto;
import com.green.boardver3.model.UserLoginVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Boardver3Mapper {
    int insBoard(Boardver3InsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int updBoard(UpdateDto dto);
}
