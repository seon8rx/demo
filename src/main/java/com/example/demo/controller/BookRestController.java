package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.DefaultDto;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book")
@RestController
public class BookRestController {

    private final BookService bookService;
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody BookDto.CreateReqDto param) {
//        if(imgfile !=null && !imgfile.isEmpty()){param.setImgfile(imgfile);}
        return ResponseEntity.ok(bookService.create(param));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto.DetailResDto>> list(BookDto.ListReqDto param) {
        return ResponseEntity.ok(bookService.list(param));
    }

    @GetMapping("")
    public ResponseEntity<BookDto.DetailResDto> detail(@RequestParam Long id) {
        return ResponseEntity.ok(bookService.detail(id));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody BookDto.UpdateReqDto param) {
        bookService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody BookDto.UpdateReqDto param) {
        bookService.delete(param.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param) {
        bookService.deletes(param);
        return ResponseEntity.ok().build();
    }
}



/*
create
list
detailList
detail
get
update
delete
deletes
*/