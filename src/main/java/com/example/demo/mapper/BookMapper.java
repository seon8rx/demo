package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.NoticeDto;

import java.util.List;

public interface BookMapper {
    BookDto.DetailResDto detail(Long id);
    List<BookDto.DetailResDto> list(BookDto.ListReqDto param);
//    List<BookDto.DetailResDto> pagedList(BookDto.PagedListReqDto param);
//    int pagedListCount(BookDto.PagedListReqDto param);
//    List<BookDto.DetailResDto> scrollList(BookDto.ScrollListReqDto param);
}
