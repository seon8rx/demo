package com.example.demo.mapper;

import com.example.demo.dto.FaqDto;
import com.example.demo.dto.NoticeDto;

import java.util.List;

public interface NoticeMapper {
    NoticeDto.DetailResDto detail(Long id);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param);
}
