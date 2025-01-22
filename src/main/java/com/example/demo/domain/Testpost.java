package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Testpost extends AuditingFields {

    @Column(unique = true, nullable = false)
    String userId;
    @Setter @Column(nullable = false)
    String title;
    @Setter @Column(nullable = true)
    String content;
    @Setter @Column(nullable = true)
    String file;

    /* 댓글기능 */
    @OneToMany(mappedBy = "testpost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    /* 댓글기능 */

    protected Testpost() {}
    private Testpost(Boolean deleted, String userId, String title, String content, String file, List<Comment> comments) {
        this.deleted = deleted;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.file = file;
        this.comments = comments != null ? comments : new ArrayList<>();
    }

    public static Testpost of(String userId, String title, String content, String file, List<Comment> comments) {
        return new Testpost(false, userId, title, content, file, comments);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
