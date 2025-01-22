package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book extends AuditingFields{
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String author;
    String isbn;
    int amount;

    protected Book(){}
    private Book(Boolean deleted, String title, String author, String isbn, int amount) {
        this.deleted = deleted;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.amount = amount;
    }

    public static Book of(String title, String author, String isbn, int amount) {
        return new Book(false, title, author, isbn, amount);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
