package com.green.boardver3.user;

import com.green.boardver3.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import com.green.boardver3.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Value("${file.dir}")
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
        if(vo == null) {    //id, pw 입력x
            return 2;
        }
        String hashedPw = commonUtils.encodeSha256(dto.getPw());
        if(vo.getPw().equals(hashedPw)) {
            return 1;   //입력 성공
        }
        return 3;   //pw 틀림
    }

    public int updBoard(UpdateDto dto) {
        return mapper.updBoard(dto);
    }

    public int updUserPic(MultipartFile pic, UserPacthDto dto) {
        // user/pk/uuid.jpg
        //경로 폴더 생성, 폴더에 사진넣기, db에 경로넣기

        String dicPath = String.format("%s/user/%d",fileDir,dto.getIuser()); // D:/download/board3/user/1 경로
        String saveFilePath = dicPath + "/" + FileUtils.makeRandomFileNm(pic.getOriginalFilename());
        File dic = new File(dicPath);
        File dic2 = new File(saveFilePath);
        if(!dic.exists()) {
            dic.mkdirs();
        }
        try {
            pic.transferTo(dic2);
            dto.setMainPic(saveFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int result = mapper.updUserPic(dto);
            if(result == 0) {
                throw new Exception("프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            //파일 삭제
            dic2.delete();
            return 0;
        }
        return mapper.updUserPic(dto);
    }
}
