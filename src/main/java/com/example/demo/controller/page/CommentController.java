package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comment")
@Controller
public class CommentController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        System.out.println("여기는 페이지 컨트롤러의 page");
        return "comment/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id) {
        System.out.println("여기는 페이지 컨트롤러의 page2");
        return "comment/" + page;
    }

}
