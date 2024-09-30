package com.example.demo.repository;

import com.example.demo.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
