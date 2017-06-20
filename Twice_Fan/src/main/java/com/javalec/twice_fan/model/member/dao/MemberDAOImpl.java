package com.javalec.twice_fan.model.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.twice_fan.model.member.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void member_insert(MemberVO vo) {
		sqlSession.insert("member.insert",vo);
	}

	@Override
	public int id_check(String u_id) {
		return sqlSession.selectOne("member.id_check",u_id);
	}

	@Override
	public int name_check(String u_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.name_check",u_name);
	}

	@Override
	public MemberVO login(String u_id, String u_pw) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("u_id",u_id);
		map.put("u_pw",u_pw);
		
		return sqlSession.selectOne("member.login",map);
	}




}
