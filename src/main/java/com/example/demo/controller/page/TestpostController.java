package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/testpost")
@Controller
public class TestpostController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "testpost/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id) {
        return "testpost/" + page;
    }

}
