package com.example.demo.service.impl;

import com.example.demo.domain.Board;
import com.example.demo.domain.User;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BoardService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        System.out.println("create");
        Map<String, Object> result = new HashMap<String, Object>();

        String username = (String) params.get("username");
        User user = userRepository.findByUsername(username);
        if(user == null){
            user = new User();
            user.setUsername((String) params.get("username"));
            user.setPassword((String) params.get("password"));
            user.setName((String) params.get("name"));
            user.setPhone((String) params.get("phone"));
            user = userRepository.save(user);

            result.put("id", user.getId());
        } else {
            result.put("id duplicated", user.getUsername());
        }
        return result;
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
        System.out.println("update");
        User user = userRepository.findById(Integer.parseInt(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
        if(params.get("username") != null) {
            user.setUsername((String) params.get("username"));
        }
        if(params.get("password") != null) {
            user.setPassword((String) params.get("password"));
        }
        if(params.get("name") != null) {
            user.setName((String) params.get("name"));
        }
        if(params.get("phone") != null) {
            user.setPhone((String) params.get("phone"));
        }
        userRepository.save(user);
        return null;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }

    @Override
    public Map<String, Object> login(Map<String, Object> params) {

        Map<String, Object> result = new HashMap<String, Object>();

        String username = (String) params.get("username");
        String password = (String) params.get("password");

        User user = userRepository.findByUsername(username);

        if(user == null){
            return null;
        }

        if(user.getPassword().equals(password)) {
            result.put("resultCode", 200);
            return result;
        } else {
            return null;
        }
    }

}
