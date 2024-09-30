package com.example.demo.service;

import com.example.demo.domain.Notice;
import java.util.List;
import java.util.Map;

public interface NoticeService {
    Map<String, Object> create(Map<String, Object> params);
    List<Notice> list();
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Map<String, Object> params);
    Notice detail(Map<String, Object> params);
}