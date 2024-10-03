package com.example.demo.dto;

import com.example.demo.domain.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class NoticeDto {

    @Setter
    @Getter
    public static class CreateReqDto {

        private String title;
        private String content;

        public Notice toEntity() {
            Notice notice = new Notice();
            notice.setTitle(getTitle());
            notice.setContent(getContent());
            return notice;
        }

    }

    /*@Builder*/
    @Setter
    @Getter
    public static class CreateResDto {

        private Long id;

    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private String title;
        private String content;

    }

}
