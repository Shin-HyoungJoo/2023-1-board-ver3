package com.green.boardver3;

import com.green.boardver3.model.Boardver3InsDto;
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
    public int postBoard(@RequestBody Boardver3InsDto dto) {
        return service.insBoard(Boardver3InsDto dto);
    }
}
