package com.example.demo.domain;

import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    @Setter @Column(unique=true, nullable=false)
    String username;

    @Setter @Column(nullable=false)
    String password;

    @Setter String name;
    @Setter String phone;

    public UserDto.CreateResDto toCreateResDto(){
        UserDto.CreateResDto res = new UserDto.CreateResDto();
        res.setId(getId());
        return res;
    }
}