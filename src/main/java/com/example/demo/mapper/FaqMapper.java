package com.example.demo.mapper;

import com.example.demo.dto.FaqDto;

import java.util.List;

public interface FaqMapper {
    FaqDto.DetailResDto detail(Long id);
    List<FaqDto.DetailResDto> list(FaqDto.ListReqDto faqDto);
}
