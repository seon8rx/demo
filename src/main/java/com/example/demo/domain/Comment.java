package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Comment extends AuditingFields {

    private String author;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testpost_id")
    private Testpost testpost;

    protected Comment() {}
    private Comment(String author, String content, Testpost testpost) {
        this.author = author;
        this.content = content;
        this.testpost = testpost;
    }

    public static Comment of(String author, String content, Testpost testpost) {
        return new Comment(author, content, testpost);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
