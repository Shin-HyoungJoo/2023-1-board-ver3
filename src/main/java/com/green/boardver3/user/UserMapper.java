package com.green.boardver3.user;


import com.green.boardver3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insBoard(UserInsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int updBoard(UpdateDto dto);
    int updUserPic(UserPacthDto dto);
}
