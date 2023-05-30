package com.green.boardver3;

import com.green.boardver3.model.Boardver3InsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Boardver3Service {
    private Boardver3Mapper mapper;

    @Autowired
    public Boardver3Service(Boardver3Mapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(Boardver3InsDto dto) {
        return mapper.insBoard(dto);
    }
}
