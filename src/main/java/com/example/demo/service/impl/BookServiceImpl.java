package com.example.demo.service.impl;

import com.example.demo.domain.Book;
import com.example.demo.domain.Notice;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public DefaultDto.CreateResDto create(BookDto.CreateReqDto param) {
        return bookRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public List<BookDto.DetailResDto> list(BookDto.ListReqDto param) {
        return detailList(bookMapper.list(param));
    }

    public List<BookDto.DetailResDto> detailList(List<BookDto.DetailResDto> list) {
        List<BookDto.DetailResDto> newList = new ArrayList<>();
        for(BookDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }

    @Override
    public BookDto.DetailResDto detail(Long id) {
        return get(id);
    }

    public BookDto.DetailResDto get(Long id) {
        return bookMapper.detail(id);
    }

    @Override
    public void update(BookDto.UpdateReqDto param) {
        Book book = bookRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            book.setDeleted(param.getDeleted());
        }
        if(param.getTitle() != null) {
            book.setTitle(param.getTitle());
        }
        if(param.getAuthor() != null) {
            book.setAuthor(param.getAuthor());
        }
        if(param.getIsbn() != null) {
            book.setIsbn(param.getIsbn());
        }
        if(param.getAmount() != book.getAmount()) {
            book.setAmount(param.getAmount());
        }
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        update(BookDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()) {
            delete(id);
        }
    }

    /*
    @Override
    public DefaultDto.PagedListResDto pagedList(NoticeDto.PagedListReqDto param){
        DefaultDto.PagedListResDto retrunVal = DefaultDto.PagedListResDto.init(param, userMapper.pagedListCount(param));
        retrunVal.setList(detailList(userMapper.pagedList(param)));
        return retrunVal;
    }
    @Override
    public List<NoticeDto.DetailResDto> scrollList(NoticeDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Notice user = userRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(user.getCreatedAt() + "");
        }
        return detailList(userMapper.scrollList(param));
    }
    */
}
