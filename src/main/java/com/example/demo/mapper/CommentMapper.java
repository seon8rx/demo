package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import java.util.List;

public interface CommentMapper {
    CommentDto.DetailResDto detail(Long id);
    List<CommentDto.DetailResDto> list(CommentDto.ListReqDto param);
    List<CommentDto.DetailResDto> deletedList(CommentDto.ListReqDto param);
}
