package com.example.demo.mapper;

import com.example.demo.dto.FaqDto;
import com.example.demo.dto.TestpostDto;

import java.util.List;

public interface TestpostMapper {
    TestpostDto.DetailResDto detail(Long id);
    List<TestpostDto.DetailResDto> list(TestpostDto.ListReqDto param);
}
