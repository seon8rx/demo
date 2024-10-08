package com.example.demo.service;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
    NoticeDto.CreateResDto create(NoticeDto.CreateReqDto param);
    List<Notice> list();
    void update(NoticeDto.UpdateReqDto param);
    Map<String, Object> delete(Map<String, Object> params);
    Notice detail(Map<String, Object> params);
}