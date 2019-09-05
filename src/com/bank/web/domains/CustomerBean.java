package com.bank.web.domains;

public class CustomerBean extends UserBean{
	
	private static final long serialVersionUID = 1L;
	private String credit;
	
	public CustomerBean() {
		credit ="1등급";
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return String.format("회원정보 \n"
				+ "=====================\n"
				+ "이름 : %s \n"
				+ "아이디 : %s \n"
				+ "비번 : %s \n"
				+ "주민번호 : %s \n"
				+ "credit : %s", super.getId(), super.getPass(),super.getName(), super.getSsn(),credit );
	}
	
	
}
