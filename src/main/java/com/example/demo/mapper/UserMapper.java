package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserMapper {
    /**/
    UserDto.DetailResDto detail(Long id);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto param);
    int pagedListCount(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}