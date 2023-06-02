package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UpdateDto;
import com.green.boardver3.user.model.UserLoginDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입", description = "" +
            "uid: [20] 회원 아이디 <br> " +
            "pw: [100] 회원 비밀번호 <br>" +
            "nm: [30] 회원명 <br>" +
            "gender: [1] 성별(M: 남성, F: 여성) <br>" +
            "addr: [100] 주소")
    public int postBoard(@RequestBody UserInsDto dto) {
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

    @PatchMapping("/pw")
    @Operation
    public int UpdPw(@RequestBody UpdateDto dto) {
        return service.updBoard(dto);

    }

    @PatchMapping(name="/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser) {
        return 0;
    }
}
