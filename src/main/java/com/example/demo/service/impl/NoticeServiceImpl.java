package com.example.demo.service.impl;

import com.example.demo.domain.Notice;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Map<String, Object> create(Map<String, Object> params) {

        Map<String, Object> result = new HashMap<String, Object>();

        Notice notice = new Notice();
        notice.setTitle(params.get("title").toString());
        notice.setContent(params.get("content").toString());
        noticeRepository.save(notice);

        result.put("success", true);
        result.put("id", notice.getId());
        return result;
    }

    @Override
    public List<Notice> list() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> params) {

        Notice notice = noticeRepository.findById(Long.parseLong(params.get("id").toString())).orElseThrow(() -> new RuntimeException(""));

        if(params.get("title") != null){
            notice.setTitle(params.get("title").toString());
        }
        if(params.get("content") != null){
            notice.setContent(params.get("content").toString());
        }

        noticeRepository.save(notice);

        return null;
    }

    @Override
    public Map<String, Object> delete(Map<String, Object> params) {
        Notice notice = noticeRepository.findById(Long.parseLong(params.get("id").toString())).orElseThrow(() -> new RuntimeException(""));
        noticeRepository.delete(notice);
        return null;
    }

    @Override
    public Notice detail(Map<String, Object> params) {
        return noticeRepository.findById(Long.parseLong(params.get("id").toString())).orElseThrow(() -> new RuntimeException(""));
    }
}
