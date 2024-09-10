package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board  {

    @Id
    Integer id;
    
    String title;
    String content;
    String author;


}
