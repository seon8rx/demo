package com.example.demo.dto;

import com.example.demo.domain.Testpost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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

        public Testpost toEntity() {
            return Testpost.of(getUserId(), getTitle(), getContent());
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
}
