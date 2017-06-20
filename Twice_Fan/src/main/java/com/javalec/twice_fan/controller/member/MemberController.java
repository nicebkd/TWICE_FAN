package com.javalec.twice_fan.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalec.twice_fan.model.member.dto.MemberVO;
import com.javalec.twice_fan.service.member.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	//로그인창 이동
	public String loginModal(){
		
		return "member/modal/login-modal.jsp";
	}
	
	//회원가입 이동
	@RequestMapping("joinView.do")
	public String joinView(){
		
		return "member/joinView";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberVO vo){
		
		memberService.member_insert(vo);
		return "home";
	}
	
	@RequestMapping("idcheck.do")
	@ResponseBody
	public ResponseEntity<String> id_check(@RequestParam String u_id){
		
		ResponseEntity<String> entity = null;
		
		int id_check = memberService.id_check(u_id);
		logger.info("IDDD" + id_check);
		if(id_check==0){
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
			return entity;
		}
			entity = new ResponseEntity<String>("fail",HttpStatus.OK);
			
		return entity;
		
	}
	
	@RequestMapping("namecheck.do")
	@ResponseBody
	public ResponseEntity<String> name_check(@RequestParam String u_name){
		
		ResponseEntity<String> entity = null;
		
		int name_check = memberService.name_check(u_name);
		logger.info("IDDD" + name_check);
		if(name_check==0){
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
			return entity;
		}
			entity = new ResponseEntity<String>("fail",HttpStatus.OK);
			
		return entity;
		
	}
	
	@RequestMapping("login.do")
	@ResponseBody
	public ResponseEntity<String> login(@RequestParam String u_id
										,@RequestParam String u_pw
										,HttpSession session){
		
		ResponseEntity<String> entity = null;
		MemberVO dto = new MemberVO();
		dto = memberService.login(u_id, u_pw);
		
		if(dto!=null){
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
			session.setAttribute("user",dto);
			return entity;
		}
		
		entity = new ResponseEntity<String>("fail",HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		memberService.logout(session);
		return "home";
	}
	
	

	

}
