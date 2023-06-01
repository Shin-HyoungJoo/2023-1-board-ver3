package com.green.boardver3.cmt;


import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardVo;
import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}/cmt")
    public int postCmt(@PathVariable int iboard,
                       @RequestBody CmtInsDto dto) {
        CmtIEntity entity = new CmtIEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    public List<CmtVo> getBoardCmt(@PathVariable int iboard,@RequestParam int page, @RequestParam(defaultValue = "5") int row) {
        CmtDto dto = new CmtDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoardCmt(dto);
    }
    @DeleteMapping("/cmt/{iboardCmt}")
    public int delBoardCmt(@PathVariable int iboardCmt, @RequestParam int iuser) {
        CmtDelDto dto = new CmtDelDto();
        dto.setIboardCmt(iboardCmt);
        dto.setIuser(iuser);
        return service.delCmt(dto);
    }

   /* @GetMapping("/{iboard}")
    public List<CmtVo> getCmt(@PathVariable int iboard,
                              @RequestBody CmtInsDto dto) {
        CmtIEntity entity = new CmtIEntity();
        entity.setIboard(dto.getIuser());
        entity.setIuser(dto.getCtnt());
        return service.insCmt();
    }*/

}
