package com.javalec.twice_fan.model.member.dao;

import com.javalec.twice_fan.model.member.dto.MemberVO;

public interface MemberDAO {

		public void member_insert(MemberVO vo);
		public int id_check(String u_id);
		public int name_check(String u_name);
		public MemberVO login(String u_id,String u_pw);
}
