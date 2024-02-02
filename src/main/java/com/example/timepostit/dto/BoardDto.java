package com.example.timepostit.dto;

import com.example.timepostit.entity.Board;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private String title;
    private String content;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime pdt;


    public Board toEntity() {
        return new Board(null,title,content,pdt);
    }
}
