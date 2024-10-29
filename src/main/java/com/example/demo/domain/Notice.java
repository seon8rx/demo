package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Notice extends AuditingFields{
    @Column(nullable=false)
    String title;
    String content;

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}