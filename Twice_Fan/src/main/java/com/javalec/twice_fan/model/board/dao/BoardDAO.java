package com.javalec.twice_fan.model.board.dao;

import java.util.List;

import com.javalec.twice_fan.model.board.dto.BoardVO;
import com.javalec.twice_fan.model.member.dto.MemberVO;

public interface BoardDAO {
	
	public List<BoardVO> list();
	public void write(BoardVO vo);
	public BoardVO view(int bno);

}
