package com.green.boardver3.cmt;


import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardVo;
import com.green.boardver3.cmt.model.CmtDto;
import com.green.boardver3.cmt.model.CmtIEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/cmt")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    public int postCmt(@RequestBody CmtInsDto dto) {
        return service.insCmt(dto);
    }

    @GetMapping("/{iboard}")
    public List<CmtVo> getCmt(@PathVariable int iboard, @RequestParam int page, int row) {
        CmtDto dto = new CmtDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selCmt(dto);
    }

}
