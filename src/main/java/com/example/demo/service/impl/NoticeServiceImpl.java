package com.example.demo.service.impl;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
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
    public NoticeDto.CreateResDto create(NoticeDto .CreateReqDto param) {

        /*Notice notice = param.toEntity();
        notice = noticeRepository.save(notice);
        NoticeDto.CreateResDto resDto = notice.toCreateResDto();
        return resDto;*/

        return noticeRepository.save(param.toEntity()).toCreateResDto();

        /*Map<String, Object> result = new HashMap<String, Object>();*/

        /*Notice notice = new Notice();
        notice.setTitle(param.getTitle());
        notice.setContent(param.getContent());
        noticeRepository.save(notice);*/

      /*  result.put("success", true);
        result.put("id", notice.getId());
        return result;*/
    }

    @Override
    public List<Notice> list() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList;
    }

    @Override
    public void update(NoticeDto.UpdateReqDto param) {

        Notice notice = noticeRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));

        if(param.getTitle() != null){
            notice.setTitle(param.getTitle());
        }
        if(param.getContent() != null){
            notice.setContent(param.getContent());
        }

        noticeRepository.save(notice);
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
