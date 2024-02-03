package com.example.timepostit.repository;

import com.example.timepostit.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("SELECT b FROM Board b WHERE b.pdt <= ?1")
    List<Board> findAllWithPdtAfter(LocalDateTime now);
}
