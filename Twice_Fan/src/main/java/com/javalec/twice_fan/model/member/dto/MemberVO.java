package com.javalec.twice_fan.model.member.dto;

import java.sql.Date;

public class MemberVO {
	
	private int u_no;
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_email;
	private Date regdate;
	private Date updatdate;
	
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatdate() {
		return updatdate;
	}
	public void setUpdatdate(Date updatdate) {
		this.updatdate = updatdate;
	}
	
	

}
