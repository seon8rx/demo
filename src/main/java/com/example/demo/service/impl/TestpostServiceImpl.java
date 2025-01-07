package com.example.demo.service.impl;

import com.example.demo.domain.Testpost;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.TestpostDto;
import com.example.demo.mapper.TestpostMapper;
import com.example.demo.repository.TestpostRepository;
import com.example.demo.service.TestpostService;
import com.example.demo.util.FileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TestpostServiceImpl implements TestpostService {

    private final TestpostRepository testpostRepository;
    private final TestpostMapper testpostMapper;
    public TestpostServiceImpl(TestpostRepository testpostRepository, TestpostMapper testpostMapper) {
        this.testpostRepository = testpostRepository;
        this.testpostMapper = testpostMapper;
    }

    @Override
    public DefaultDto.CreateResDto create(TestpostDto.CreateReqDto param) {
        return testpostRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public TestpostDto.DetailResDto detail(Long id) {
        return get(id);
    }

    @Override
    public List<TestpostDto.DetailResDto> list(TestpostDto.ListReqDto param) {
        return detailList(testpostMapper.list(param));
    }
    @Override
    public List<TestpostDto.DetailResDto> deletedList(TestpostDto.ListReqDto param) {
        return detailList(testpostMapper.deletedList(param));
    }

    @Override
    public void update(TestpostDto.UpdateReqDto param) {
        Testpost testpost = testpostRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getTitle() != null) {
            testpost.setTitle(param.getTitle());
        }
        if(param.getContent() != null) {
            testpost.setContent(param.getContent());
        }
        if(param.getDeleted() != null) {
            testpost.setDeleted(param.getDeleted());
        }
        testpostRepository.save(testpost);
    }

    @Override
    public void delete(Long id) {
        update(TestpostDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public TestpostDto.DetailResDto get(Long id) {
        return testpostMapper.detail(id);
    }

    public List<TestpostDto.DetailResDto> detailList(List<TestpostDto.DetailResDto> param) {
        List<TestpostDto.DetailResDto> newList = new ArrayList<>();
        for(TestpostDto.DetailResDto each : param) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    /*---------*/

    //FILE UPLOAD
    @Override
    public void saveFile(MultipartFile param) throws IOException {

        String fileName = param.getOriginalFilename();

        String filePath = "/Users/seooonggyu/Documents/testpostFileUpload/";
        File newfile = new File(filePath);
        if(!newfile.exists()) { newfile.mkdirs(); }

        Date date = new Date();
        String temp_date = date.getTime() + "";
        String finalName = filePath + temp_date + "_" + fileName;
        FileCopyUtils.copy(param.getBytes(), new File(finalName));

        ResponseEntity.status(HttpStatus.OK).body(temp_date + "_" + fileName);

    }
}
