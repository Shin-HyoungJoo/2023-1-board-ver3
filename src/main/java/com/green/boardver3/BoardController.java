package com.green.boardver3;

import com.green.boardver3.model.BoardInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
