package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.DefaultDto;
import com.example.demo.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/comment")
@RestController
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    /*---------*/
    //CREATE
    @PostMapping("/{testpostId}")
    public ResponseEntity<DefaultDto.CreateResDto> create(@PathVariable Long testpostId, @RequestBody CommentDto.CreateReqDto param){
        return ResponseEntity.ok(commentService.create(testpostId, param));
    }
    
    //READ
    @GetMapping("/detail")
    public ResponseEntity<CommentDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(commentService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<CommentDto.DetailResDto>> list(CommentDto.ListReqDto param){
        return ResponseEntity.ok(commentService.list(param));
    }
    @GetMapping("/deleted_list")
    public ResponseEntity<List<CommentDto.DetailResDto>> deletedList(CommentDto.ListReqDto param){
        return ResponseEntity.ok(commentService.deletedList(param));
    }

    //UPDATE
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody CommentDto.UpdateReqDto param){
        commentService.update(param);
        return ResponseEntity.ok().build();
    }

    //DELETE
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody CommentDto.UpdateReqDto param){
        commentService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        commentService.deletes(param);
        return ResponseEntity.ok().build();
    }

}
