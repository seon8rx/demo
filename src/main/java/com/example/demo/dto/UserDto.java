package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class UserDto {

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
    public static class CreateReqDto extends DefaultDto.UpdateReqDto {
        private String username;
        private String password;
        private String name;
        private String phone;

        public User toEntity() {
            return User.of(getUsername(), getPassword(), getName(), getPhone());
        }
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String password;
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private String username;
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
//        private String username;
        private String name;
        private String phone;

    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private String name;
        private String phone;
    }

}