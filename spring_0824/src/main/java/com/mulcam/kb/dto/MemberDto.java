package com.mulcam.kb.dto;

public class MemberDto {
	private String name, passwd, tel;
	
	public MemberDto() {
		
	}

	public MemberDto(String name, String passwd, String tel) {
		super();
		this.name = name;
		this.passwd = passwd;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "name=" + name + ", passwd=" + passwd + ", tel=" + tel;
	}
}
