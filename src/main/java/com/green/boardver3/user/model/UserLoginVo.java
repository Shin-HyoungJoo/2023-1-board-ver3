package com.green.boardver3.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginVo {
    private int iuser;
    private String uid;
    private String pw;
    private String nm;
    private String gender;
    private String addr;
    private String main_pic;
}
