package com.javalec.twice_fan.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.twice_fan.model.board.dao.BoardDAO;
import com.javalec.twice_fan.model.board.dto.BoardVO;
import com.javalec.twice_fan.model.member.dto.MemberVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> list() {
		return boardDAO.list();
	}

	@Override
	public void write(BoardVO vo) {
		 boardDAO.write(vo);
	}

	@Override
	public BoardVO view(int bno) {
		return boardDAO.view(bno);
	}
}
