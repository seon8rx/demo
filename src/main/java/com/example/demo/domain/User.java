package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends AuditingFields{

    @Column(unique=true, nullable=false) String username;
    @Column(nullable=false) String password;
    String name;
    String phone;

    protected User() {}
    private User(Boolean deleted, String username, String password, String name, String phone) {
        this.deleted = deleted;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of (String username, String password, String name, String phone){
        return new User(false, username, password, name, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}