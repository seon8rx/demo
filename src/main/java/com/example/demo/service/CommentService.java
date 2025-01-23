package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.TestpostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    /*CREATE 댓글 생성*/
    DefaultDto.CreateResDto create(Long testpost_id, CommentDto.CreateReqDto param);

    //READ
    CommentDto.DetailResDto detail(Long id);
    List<CommentDto.DetailResDto> list(CommentDto.ListReqDto param);
    List<CommentDto.DetailResDto> deletedList(CommentDto.ListReqDto param);

    //DELETE
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);

    //UPDATE
    void update(CommentDto.UpdateReqDto param);

    /*특정 testpost한테 작성된 댓글만 모두 불러오기*/
    List<CommentDto.DetailResDto> findCommentsByTestpostId(Long testpostId);
}
