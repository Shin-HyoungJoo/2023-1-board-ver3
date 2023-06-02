package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Value("${file.dir")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int insBoard(UserInsDto dto) {
        String hashPw = commonUtils.encodeSha256(dto.getPw());
        dto.setPw(hashPw);
        return mapper.insBoard(dto);
    }

    public int login(UserLoginDto dto) {
        UserLoginVo vo = mapper.selUserByUid(dto);
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

    public int updUserPic(MultipartFile pic, UserPacthDto dto) {
        // user/pk/uuid.jpg

        return mapper.updUserPic(dto);
    }
}
