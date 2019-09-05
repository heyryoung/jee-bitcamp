package com.bank.web.domains;

public class AdminBean extends UserBean{

	private static final long serialVersionUID = 1L;
	private String sabun;

	public AdminBean() {
		sabun = "1234";
	}
	
	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	@Override
	public String toString() {
		return String.format("회원정보 \n"
				+ "=====================\n"
				+ "이름 : %s \n"
				+ "아이디 : %s \n"
				+ "비번 : %s \n"
				+ "주민번호 : %s \n"
				+ "사번 : %s", super.getId(), super.getPass(),super.getName(), super.getSsn(),sabun );
	}
	
	
	
}
