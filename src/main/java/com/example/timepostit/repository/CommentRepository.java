package com.example.timepostit.repository;

import com.example.timepostit.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("SELECT c FROM Comment c where c.board.id = ?1")
    List<Comment> findByBoardId(Long board_id);
}
