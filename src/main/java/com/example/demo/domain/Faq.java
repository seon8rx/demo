package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Faq extends AuditingFields {

    Long userId;
    @Column(nullable = false)
    String title;
    String content;

    protected Faq() {}
    private Faq(Boolean deleted, Long userId, String title, String content) {
        this.deleted = deleted;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static Faq of(Long userId, String title, String content) {
        return new Faq(false, userId, title, content);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}