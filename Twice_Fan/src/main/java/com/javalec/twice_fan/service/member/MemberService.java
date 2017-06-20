package com.javalec.twice_fan.service.member;

import javax.servlet.http.HttpSession;

import com.javalec.twice_fan.model.member.dto.MemberVO;

public interface MemberService {
	
	public void member_insert(MemberVO vo);
	public int id_check(String u_id);
	public int name_check(String u_name);
	public MemberVO login(String u_id,String u_pw);	
	public void logout(HttpSession session);
	

}
