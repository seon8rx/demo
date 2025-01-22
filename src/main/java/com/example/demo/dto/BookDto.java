package com.example.demo.dto;

import com.example.demo.domain.Book;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class BookDto {

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {
        private String title;
        private String author;
        private String isbn;
        private int amount;

        public Book toEntity() {
            return Book.of(getTitle(), getAuthor(), getIsbn(), getAmount());
        }
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String title;
        private String author;
        private String isbn;
        private int amount;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private String title;
        private String author;
        private String isbn;
        private int amount;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private String title;
    }

    /*
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String title;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private String title;
    }
    */
}
