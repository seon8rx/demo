package com.example.demo.mapper;

import com.example.demo.dto.NoticeDto;
import com.example.demo.dto.TestpostDto;

import java.util.List;

public interface TestpostMapper {
    TestpostDto.DetailResDto detail(Long id);
    List<TestpostDto.DetailResDto> list(TestpostDto.ListReqDto param);
    List<TestpostDto.DetailResDto> deletedList(TestpostDto.ListReqDto param);

    //PAGED LIST
    int pagedListCount(TestpostDto.PagedListReqDto param);
    List<TestpostDto.DetailResDto> pagedList(TestpostDto.PagedListReqDto param);
}
