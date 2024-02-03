package com.example.timepostit.controller;

import com.example.timepostit.dto.BoardDto;
import com.example.timepostit.entity.Board;
import com.example.timepostit.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/boards/{id}")
    public String showBoard(@PathVariable Long id, Model model){
        Board board = boardRepository.findById(id).orElse(null);
        model.addAttribute("board",board);
        return "boards/show";
    }
    @GetMapping("/boards")
    public String showIndex(Model model){
        List<Board> boardList = boardRepository.findAll();
        log.info(boardList.toString());
        model.addAttribute("boardList",boardList);
        return "boards/index";
    }
}
