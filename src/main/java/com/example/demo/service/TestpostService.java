package com.example.demo.service;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.TestpostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestpostService {

    //CREATE
    DefaultDto.CreateResDto create(TestpostDto.CreateReqDto param);
    //READ
    TestpostDto.DetailResDto detail(Long id);
    List<TestpostDto.DetailResDto> list(TestpostDto.ListReqDto param);
    //UPDATE
    void update(TestpostDto.UpdateReqDto param);
    //DELETE
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);

}
