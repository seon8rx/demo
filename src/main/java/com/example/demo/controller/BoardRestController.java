package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {


    private final BoardService boardService;;
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }



    List<Map<String, Object>> boardList = new ArrayList<>();

    @GetMapping("/create") // 이 안에 있는 주소값은 꼭 유니크해야함!! (클래스 안에서만)
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {

        return boardService.createBoard(params);

//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("resultCode", 200);

        /*
        이전에 컨트롤러 필드에 저장해보는 코드
        String title = (String) params.get("title");
        String content = params.get("content") + "";
        String author = params.get("author") + "";
        int order = boardList.size();

        Map<String, Object> boardMap = new HashMap<>();
        boardMap.put("order", ++order);
        boardMap.put("title", title);
        boardMap.put("content", content);
        boardMap.put("author", author);
        boardList.add(boardMap);

        System.out.println("boardList = " + boardList);
        */
    }

    @GetMapping("/list")
    public List<Board> list() {
//        return boardList;
        return boardService.listBoard();
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String order) {

        int index = Integer.parseInt(order) - 1;
        Map<String, Object> boardMap = boardList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        resultMap.put("detail_board", boardMap);

        return resultMap;
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {

        int index = Integer.parseInt(params.get("order") + "") - 1;
        Map<String, Object> boardMap = boardList.get(index);
        boardMap.put("title", params.get("title"));
        boardMap.put("content", params.get("content"));
        boardMap.put("author", params.get("author"));
        //boardList.add

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        //resultMap.put("detail_board", boardMap);

        return resultMap;
    }
}