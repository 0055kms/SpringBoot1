package com.example.timepostit.service;

import com.example.timepostit.entity.Comment;
import com.example.timepostit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> showComment(Long id) {
        return commentRepository.findByBoardId(id);
    }
}
