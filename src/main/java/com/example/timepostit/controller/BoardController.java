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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;
    @GetMapping("/boards/new")
    public String newBoard(){
        return "/boards/new";
    }
    @PostMapping("/boards/create")
    public String createBoard(BoardDto boardDto){
        log.info(boardDto.toString());
        Board board = boardDto.toEntity();
        log.info(board.toString());
        Board saved = boardRepository.save(board);
        log.info(saved.toString());
        return "redirect:/boards/"+saved.getId();
    }
    @GetMapping("/boards/{id}")
    public String showBoard(@PathVariable Long id, Model model){
        Board board = boardRepository.findById(id).orElse(null);
        model.addAttribute("board",board);
        return "/boards/show";
    }
    @GetMapping("/boards")
    public String showIndex(Model model){
        List<Board> boardList = boardRepository.findAllWithPdtAfter(LocalDateTime.now());
        log.info("now의 시간: " + LocalDateTime.now());
        log.info(boardList.toString());
        model.addAttribute("boardList",boardList);
        return "/boards/index";
    }
    @GetMapping("/boards/{id}/edit")
    public String editBoard(@PathVariable Long id,Model model){
        Board board = boardRepository.findById(id).orElse(null);
        model.addAttribute("board",board);
        return "boards/edit";
    }
    @PostMapping("/boards/{id}/update")
    public String updateBoard(@PathVariable Long id, BoardDto boardDto){
        Board newBoard = boardDto.toEntity();
        log.info("수정요청" + newBoard.toString());
        Board target = boardRepository.findById(id).orElse(null);
        if (target != null) boardRepository.save(newBoard);
        return "redirect:/boards/"+newBoard.getId();
    }
    @GetMapping("/boards/{id}/delete")
    public String deleteBoard(@PathVariable Long id){
        log.info(id + "번 삭제 요청");
        Board target = boardRepository.findById(id).orElse(null);
        if (target != null) boardRepository.delete(target);
        return "redirect:/boards";
    }
}
