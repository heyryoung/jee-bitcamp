package com.bank.web.services;

import java.util.List;

import com.bank.web.domains.AccountBean;

public interface AccountService {

	public void createAccount(String money);
	public String createAccountNum();
	// 계좌번호 생성(1234-5678)
	public List<AccountBean> findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccounts();
	public boolean existAccountNum(String accountNum);
	public String findDate(); // 오늘날짜, 현재시간(분까지) 반환
	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);
}
