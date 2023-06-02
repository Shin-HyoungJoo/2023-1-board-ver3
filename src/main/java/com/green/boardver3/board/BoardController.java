package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int BoardService(@RequestBody BoardInsDto dto) {
        return service.insBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "30") int row) {
        BoardDto d1 = new BoardDto();
        d1.setRow(row);
        d1.setPage(page);
        return service.selBoard(d1);
    }

    @GetMapping("/maxpage")
    public int getMaxBoard(@RequestParam int row) {
        return service.selMaxBoard(row);
    }

    @GetMapping("/{iboard}")
    public BoardDetailVo getDetailBoard(@PathVariable int iboard) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        return service.selBoardDetail(dto);
    }

    @DeleteMapping
    public int delBoard(@RequestParam int iboard, int iuser) throws Exception {
        BoardDelDto dto = new BoardDelDto();
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.delBoard(dto);
    }

    @PutMapping
    public int updBoard(@RequestBody BoardUpdDto dto) {
        return service.updBoard(dto);
    }
}
