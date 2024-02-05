package com.example.timepostit.controller;

import com.example.timepostit.dto.BoardDto;
import com.example.timepostit.entity.Board;
import com.example.timepostit.repository.BoardRepository;
import com.example.timepostit.service.BoardService;
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
    private BoardService boardService;
    @GetMapping("/boards/new")
    public String newBoard(){
        return "/boards/new";
    }
    @PostMapping("/boards/create")
    public String createBoard(BoardDto boardDto){
        log.info("생성요청" + boardDto.toString());
        Board saved = boardService.createBoard(boardDto);
        return "redirect:/boards/"+saved.getId();
    }
    @GetMapping("/boards/{id}")
    public String showBoard(@PathVariable Long id, Model model){
        Board board = boardService.showBoard(id);
        model.addAttribute("board",board);
        return "/boards/show";
    }
    @GetMapping("/boards")
    public String showIndex(Model model){
        List<Board> boardList = boardService.showIndex();
        model.addAttribute("boardList",boardList);
        return "/boards/index";
    }
    @GetMapping("/boards/{id}/edit")
    public String editBoard(@PathVariable Long id,Model model){
        Board board = boardService.editBoard(id);
        model.addAttribute("board",board);
        return "boards/edit";
    }
    @PostMapping("/boards/{id}/update")
    public String updateBoard(@PathVariable Long id, BoardDto boardDto){
        log.info("수정요청" + boardDto.toString());
        Board newBoard = boardService.updateBoard(id,boardDto);
        return "redirect:/boards/"+newBoard.getId();
    }
    @GetMapping("/boards/{id}/delete")
    public String deleteBoard(@PathVariable Long id){
        log.info(id + "번 삭제 요청");
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }
}
