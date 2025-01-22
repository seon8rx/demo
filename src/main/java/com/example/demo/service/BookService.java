package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    DefaultDto.CreateResDto create(BookDto.CreateReqDto param);
    List<BookDto.DetailResDto> list(BookDto.ListReqDto param);
    BookDto.DetailResDto detail(Long id);
    void update(BookDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);

    /*-----*/
//    DefaultDto.PagedListResDto pagedList(BookDto.PagedListReqDto param);
//    List<BookDto.DetailResDto> scrollList(BookDto.ScrollListReqDto param);
}
