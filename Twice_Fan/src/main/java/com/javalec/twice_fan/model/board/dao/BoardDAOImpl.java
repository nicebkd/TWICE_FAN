package com.javalec.twice_fan.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.twice_fan.model.board.dto.BoardVO;
import com.javalec.twice_fan.model.member.dto.MemberVO;

import oracle.net.aso.b;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardVO> list() {
		
		return sqlSession.selectList("board.list");
	}

	@Override
	public void write(BoardVO vo) {
		sqlSession.insert("board.write",vo);
	}

	@Override
	public BoardVO view(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.view",bno);
	}

}
