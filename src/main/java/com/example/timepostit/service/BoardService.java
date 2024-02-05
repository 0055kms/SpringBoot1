package com.example.timepostit.service;

import com.example.timepostit.dto.BoardDto;
import com.example.timepostit.entity.Board;
import com.example.timepostit.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public Board createBoard(BoardDto boardDto){
        Board newBoard = boardDto.toEntity();
        return boardRepository.save(newBoard);
    }
    public Board showBoard(Long id){
        return boardRepository.findById(id).orElse(null);
    }
    public List<Board> showIndex(){
        return boardRepository.findAllWithPdtAfter(LocalDateTime.now());
    }
    public Board editBoard(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
    public Board updateBoard(Long id, BoardDto boardDto) {
        Board newBoard = boardDto.toEntity();
        Board target = boardRepository.findById(id).orElse(null);
        if (target != null) boardRepository.save(newBoard);
        return newBoard;
    }
    public void deleteBoard(Long id) {
        Board target = boardRepository.findById(id).orElse(null);
        if (target != null)boardRepository.delete(target);
    }
}
