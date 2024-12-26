package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Testpost extends AuditingFields {

    @Column(unique = true, nullable = false)
    String userId;
    @Setter @Column(nullable = false)
    String title;
    @Setter @Column(nullable = true)
    String content;

    protected Testpost() {}
    private Testpost(Boolean deleted, String userId, String title, String content) {
        this.deleted = deleted;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static Testpost of(String userId, String title, String content) {
        return new Testpost(false, userId, title, content);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
