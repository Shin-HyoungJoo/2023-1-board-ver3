package com.green.boardver3.user;


import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UpdateDto;
import com.green.boardver3.user.model.UserLoginDto;
import com.green.boardver3.user.model.UserLoginVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insBoard(UserInsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int updBoard(UpdateDto dto);
}
