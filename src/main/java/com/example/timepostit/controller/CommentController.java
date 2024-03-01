package com.example.timepostit.controller;

import com.example.timepostit.dto.CommentDto;
import com.example.timepostit.entity.Comment;
import com.example.timepostit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/comments/create/{id}")
    public String createComment(@PathVariable Long id, CommentDto commentDto){

        return "";
    }

}
