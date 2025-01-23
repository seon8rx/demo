package com.example.demo.service.impl;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Testpost;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.TestpostDto;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.TestpostRepository;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TestpostRepository testpostRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, TestpostRepository testpostRepository, CommentMapper commentMapper /*@Qualifier("commentService") CommentService commentService*/) {
        this.commentRepository = commentRepository;
        this.testpostRepository = testpostRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public DefaultDto.CreateResDto create(Long testpost_id, CommentDto.CreateReqDto param) {
        Testpost testpost = testpostRepository.findById(testpost_id)
                .orElseThrow(() -> new IllegalArgumentException("Testpost not found"));

        Comment comment = param.toEntity();
        comment.setTestpost(testpost);
        /*comment.setTestpost(testpostRepository.findById(testpost_id)
                .orElseThrow(() -> new IllegalArgumentException("Testpost not found")));
                이렇게 해도 되지 않나?*/

        return commentRepository.save(comment).toCreateResDto();
    }

    @Override
    public void update(CommentDto.UpdateReqDto param) {
        Comment comment = commentRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getAuthor() != null) {
            comment.setAuthor(param.getAuthor());
        }
        if(param.getContent() != null) {
            comment.setContent(param.getContent());
        }
        if(param.getDeleted() != null) {
            comment.setDeleted(param.getDeleted());
        }
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        update(CommentDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    @Override
    public CommentDto.DetailResDto detail(Long id) {
        return get(id);
    }

    @Override
    public List<CommentDto.DetailResDto> list(CommentDto.ListReqDto param) {
        System.out.println(param.getAuthor());
        System.out.println("여기는 서비스임플의 List");
        return detailList(commentMapper.list(param));
    }

    @Override
    public List<CommentDto.DetailResDto> deletedList(CommentDto.ListReqDto param) {
        return detailList(commentMapper.deletedList(param));
    }

    public CommentDto.DetailResDto get(Long id) {
        return commentMapper.detail(id);
    }

    public List<CommentDto.DetailResDto> detailList(List<CommentDto.DetailResDto> param) {
        System.out.println("여기는 서비스임플의 detailList");
        List<CommentDto.DetailResDto> newList = new ArrayList<>();
        for(CommentDto.DetailResDto each : param) {
            newList.add(get(each.getId()));
        }

        for(CommentDto.DetailResDto each : newList) {
            System.out.println("\n@@@@"+each.getTestpostTitle()+", "+each.getTestpostId()+"\n");
        }
        return newList;
    }

    /*특정 testpost한테 작성된 댓글만 모두 불러오기*/
    @Override
    public List<CommentDto.DetailResDto> findCommentsByTestpostId(Long testpostId) {
        return commentMapper.myComment(testpostId);
    }
}
