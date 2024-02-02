package com.example.timepostit.controller;

import com.example.timepostit.dto.BoardDto;
import com.example.timepostit.entity.Board;
import com.example.timepostit.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;
    @GetMapping("/boards/new")
    public String newBoard(){
        return "boards/new";
    }
    @PostMapping("/boards/create")
    public String createBoard(BoardDto boardDto){
        log.info(boardDto.toString());
        Board board = boardDto.toEntity();
        log.info(board.toString());
        Board saved = boardRepository.save(board);
        log.info(saved.toString());
        return "";
    }

}
