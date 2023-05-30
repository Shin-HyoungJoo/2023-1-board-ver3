package com.green.boardver3;

import com.green.boardver3.model.Boardver3InsDto;
import com.green.boardver3.model.UserLoginDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Boardver3Controller {

    private final Boardver3Service service;

    @Autowired
    public Boardver3Controller(Boardver3Service service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입", description = "" +
            "uid: [20] 회원 아이디 <br> " +
            "pw: [100] 회원 비밀번호 <br>" +
            "nm: [30] 회원명 <br>" +
            "gender: [1] 성별(M: 남성, F: 여성) <br>" +
            "addr: [100] 주소")
    public int postBoard(@RequestBody Boardver3InsDto dto) {
        return service.insBoard(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "" +
            "리턴값 : " +
            "(1) 로그인 성공 <br>" +
            "(2) 아이디 없음 <br>" +
            "(3) 비밀번호 다름")
    public int postLoginUser(@RequestBody UserLoginDto dto) {
        return service.login(dto);
    }
}
