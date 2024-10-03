package com.example.demo.domain;

import com.example.demo.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Notice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    @Setter @Column (nullable = false)
    String title;
    @Setter
    String content;

    public NoticeDto.CreateResDto toCreateResDto() {
        NoticeDto.CreateResDto dto = new NoticeDto.CreateResDto(); //@Builder 사용하면 안 되고 아래 주석으로 사용
        dto.setId(id);
        return dto;
        /*return NoticeDto.CreateResDto.builder().id(id).build();*/
    }

}