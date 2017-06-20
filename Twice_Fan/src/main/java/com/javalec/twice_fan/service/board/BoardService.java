package com.javalec.twice_fan.service.board;

import java.util.List;

import com.javalec.twice_fan.model.board.dto.BoardVO;

public interface BoardService {

	public List<BoardVO> list();
	public void write(BoardVO vo);
	public BoardVO view(int bno);
	
}
