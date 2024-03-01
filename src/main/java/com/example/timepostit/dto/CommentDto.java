package com.example.timepostit.dto;

import com.example.timepostit.entity.Board;
import com.example.timepostit.entity.Comment;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private Long boardId;
    private String content;

}
