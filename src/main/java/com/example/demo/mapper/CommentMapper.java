package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import java.util.List;
import java.util.Map;

public interface CommentMapper {
    CommentDto.DetailResDto detail(Long id);
    List<CommentDto.DetailResDto> list(CommentDto.ListReqDto param);
    List<CommentDto.DetailResDto> deletedList(CommentDto.ListReqDto param);

    /*특정 testpost한테 작성된 댓글만 모두 불러오기*/
    List<CommentDto.DetailResDto> myComment(Long testpostId);}
