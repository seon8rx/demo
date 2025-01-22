package com.example.demo.dto;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Testpost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class CommentDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {

        private String author;
        private String content;
        private Testpost testpost;

        public Comment toEntity() {
            return Comment.of(getAuthor(), getContent(), getTestpost());
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {

        private String author;
        private String content;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {

        private String author;
        private String content;
        private Long testpost_id;
        private Testpost testpost;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {

        private String author;

    }
}
