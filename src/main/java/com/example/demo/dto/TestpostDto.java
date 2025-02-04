package com.example.demo.dto;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Testpost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class TestpostDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto {

        private String userId;
        private String title;
        private String content;

        private MultipartFile file;
        private String sfile;

        private List<CommentDto.CreateReqDto> commentsDto = new ArrayList<>();

        public Testpost toEntity() {
            List<Comment> commentsEntity = new ArrayList<>();
            if (commentsDto != null) {
                commentsDto.forEach(c -> {
                    Comment comment = c.toEntity();
                    commentsDto.add(c);
                });
            }
            return Testpost.of(getUserId(), getTitle(), getContent(), getSfile(), commentsEntity);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {

        private String userId;
        private String title;
        private String content;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {

        private String userId;
        private String title;
        private String content;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {

        private String title;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String userId;
        private String title;
    }

    /*@AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class PagedListResDto extends DefaultDto.PagedListResDto {
        private String userId;
        private String title;
    }*/
}
