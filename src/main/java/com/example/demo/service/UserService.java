package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    /*DefaultDto.CreateResDto signup(UserDto.CreateReqDto param);
    DefaultDto.LoginResDto login(DefaultDto.LoginReqDto param);
    boolean id(String username); //????
    *//**//*
    DefaultDto.CreateResDto create(UserDto.CreateReqDto params);
    void update(UserDto.UpdateReqDto param);
    void delete(Long id);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    UserDto.DetailResDto detail(Long id);*/

    DefaultDto.CreateResDto login(UserDto.LoginReqDto param);
    DefaultDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(Long id);
    UserDto.DetailResDto detail(Long id);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}