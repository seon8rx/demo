package com.example.demo.service.impl;

import com.example.demo.domain.Faq;
import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.FaqDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.FaqMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    /*
    @Override
    public DefaultDto.CreateResDto signup(UserDto.CreateReqDto param) {
        if(param.getUsername() == null || param.getPassword() == null || param.getName() == null || param.getPhone() == null){
            throw new RuntimeException("not enough parameters");
        }
        return create(param);
    }
    */
    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        System.out.println("create");
        User user = userRepository.findByUsername(param.getUsername());
        if(user != null){ throw new RuntimeException("id exist"); }
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public DefaultDto.CreateResDto login(UserDto.LoginReqDto param) {
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if(user == null) {
            throw new RuntimeException("id password not matched");
        }
        return DefaultDto.CreateResDto.builder().id(user.getId()).build();
    }

    /*@Override
    public boolean id(String username) {
        User user = userRepository.findByUsername(username);
        return user == null;
    }*/

    /**/
    @Override
    public void update(UserDto.UpdateReqDto param) {
        System.out.println("update");
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getPassword() != null) {
            user.setPassword(param.getPassword());
        }
        if(param.getName() != null) {
            user.setName(param.getName());
        }
        if(param.getPhone() != null) {
            user.setPhone(param.getPhone());
        }
        userRepository.save(user);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        return detailList(userMapper.list(param));
    }
    @Override
    public UserDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
    }


    /**/
    public UserDto.DetailResDto get(Long id) {
        return userMapper.detail(id);
    }
    public List<UserDto.DetailResDto> detailList(List<UserDto.DetailResDto> list) {
        List<UserDto.DetailResDto> newList = new ArrayList<>();
        for(UserDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto result = DefaultDto.PagedListResDto.init(param, userMapper.pagedListCount(param));
        result.setList(detailList(userMapper.pagedList(param)));
        return result;
    }

    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param) {
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null) {
            User user = userRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(user.getCreatedAt() + "");
        }
        return detailList(userMapper.scrollList(param));
    }
}