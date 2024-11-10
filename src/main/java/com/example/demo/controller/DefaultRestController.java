package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        String filePath = "/Users/seooonggyu/Documents/fallsprbasic/";
        File newfile = new File(filePath);
        if(!newfile.exists()) {
            newfile.mkdirs();
        }

        Date date = new Date();
        String temp_date = date.getTime() + "";
        String finalName = filePath + temp_date + "_" + fileName;
        FileCopyUtils.copy(file.getBytes(), new File(finalName));

        return ResponseEntity.status(HttpStatus.OK).body(temp_date + "_" + fileName);
    }
/*
    @GetMapping("/mapTest") // 이 안에 있는 주소값은 꼭 유니크해야함!! (클래스 안에서만)
    public Map<String, Object> mapTest() {

        Map<String, Object> a_map = new HashMap<String,Object>();
        a_map.put("hint", "p");
        a_map.put("hint2", "t");
        System.out.println(a_map);
        Object value = a_map.get("hint");
        System.out.println("value = " + value);
        a_map.remove("hint");
        System.out.println(a_map);

        return a_map;
    }

    @GetMapping("/listTest") // 이 안에 있는 주소값은 꼭 유니크해야함!! (클래스 안에서만)
    public List<String> listTest(@RequestParam int item1, @RequestParam int item2) {

        System.out.println("item1 = " + item1);
        System.out.println("item2 = " + item2);

        int sum = item1 + item2;

        List<String> a_list = new ArrayList<String>();
        a_list.add("sum : " + sum);

//        a_list.add("11");
//        a_list.add("22");
//        a_list.add("33");
//        a_list.add("44");
//        int size = a_list.size();
//        System.out.println(a_list.get(0));

        return a_list;
    }

    @GetMapping("/paramTest") // 이 안에 있는 주소값은 꼭 유니크해야함!! (클래스 안에서만)
    public Map<String, Object> paramTest(@RequestParam Map<String, Object> map) {

        System.out.println("item1 = " + map.get("item1"));
        System.out.println("item2 = " + map.get("item2"));

        int sum = Integer.parseInt(map.get("item1") + "") + Integer.parseInt(map.get("item2") + "");

        Map<String, Object> map_result = new HashMap<String, Object>();
        map_result.put("item1", map.get("item1"));
        map_result.put("item2", map.get("item2"));

        return map_result;
    }
    */

}
