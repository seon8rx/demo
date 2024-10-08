package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.User;
import com.example.demo.service.BoardService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserRestController {

    private final UserService userService;;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create") // 이 안에 있는 주소값은 꼭 유니크해야함!! (클래스 안에서만)
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        return userService.create(params);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/detail")
    public User detail(@RequestParam Integer id) {
        return userService.detail(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        return userService.update(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        return userService.delete(Integer.parseInt(params.get("id") + ""));
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam Map<String, Object> params) {
        return userService.login(params);
    }
}
