package com.javalec.twice_fan.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.javalec.twice_fan.model.member.dao.MemberDAO;
import com.javalec.twice_fan.model.member.dto.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAO memberDAO;

	@Override
	public void member_insert(MemberVO vo) {
		memberDAO.member_insert(vo);
	}

	@Override
	public int id_check(String u_id) {
		return memberDAO.id_check(u_id);
	}

	@Override
	public int name_check(String u_name) {
		return memberDAO.name_check(u_name);
	}

	@Override
	public MemberVO login(String u_id, String u_pw) {
		return memberDAO.login(u_id, u_pw);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	

}
