package com.example.demo.service.impl;

import com.example.demo.domain.Board;
import com.example.demo.domain.User;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BoardService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, Object> create(Map<String, Object> params) {
        User user = new User();

        user.setUsername(params.get("username").toString());
        user.setPassword(params.get("password").toString());
        user.setName(params.get("name").toString());
        user.setPhone(params.get("phone").toString());

        userRepository.save(user);

        return null;
    }

    @Override
    public List<User> list() {

        return userRepository.findAll();

    }

    @Override
    public User detail(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public Map<String, Object> update(Map<String, Object> params) {
        User user = userRepository.findById(Integer.parseInt(params.get("id").toString())).orElseThrow(() -> new RuntimeException(""));
        user.setName(params.get("name").toString());
        user.setPhone(params.get("phone").toString());
        userRepository.save(user);
        return null;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }

}
