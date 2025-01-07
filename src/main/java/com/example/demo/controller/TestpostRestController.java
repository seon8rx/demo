package com.example.demo.controller;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.TestpostDto;
import com.example.demo.service.TestpostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/testpost")
@RestController
public class TestpostRestController {

    private final TestpostService testpostService;

    public TestpostRestController(TestpostService testpostService) {
        this.testpostService = testpostService;
    }

    /*---------*/
    //CREATE
    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody TestpostDto.CreateReqDto param){
        return ResponseEntity.ok(testpostService.create(param));
    }

    //READ
    @GetMapping("/detail")
    public ResponseEntity<TestpostDto.DetailResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(testpostService.detail(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<TestpostDto.DetailResDto>> list(TestpostDto.ListReqDto param){
        return ResponseEntity.ok(testpostService.list(param));
    }
    @GetMapping("/deleted_list")
    public ResponseEntity<List<TestpostDto.DetailResDto>> deletedList(TestpostDto.ListReqDto param){
        return ResponseEntity.ok(testpostService.deletedList(param));
    }

    //UPDATE
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody TestpostDto.UpdateReqDto param){
        testpostService.update(param);
        return ResponseEntity.ok().build();
    }

    //DELETE
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody TestpostDto.UpdateReqDto param){
        testpostService.delete(param.getId());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        testpostService.deletes(param);
        return ResponseEntity.ok().build();
    }
    /*---------*/

    //FILE UPLOAD
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile param) {
        try {
            testpostService.saveFile(param);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
