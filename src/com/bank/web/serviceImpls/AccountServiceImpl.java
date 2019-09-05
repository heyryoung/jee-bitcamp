package com.bank.web.serviceImpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService {

	
	private List<AccountBean> acclist;
	
	public AccountServiceImpl() {
		acclist = new ArrayList<>();
	}
	
	@Override
	public void createAccount(String money) {
		
		AccountBean ab = new AccountBean();
		
		ab.setMoney(String.valueOf(money));
		ab.setAccountNum(createAccountNum());
		ab.setToday(findDate());
		
		System.out.println(ab.toString());
		acclist.add(ab);
		
	}

	@Override
	public String createAccountNum() {
		String accountNum="";
		Random  rd = new Random();

		for (int i = 0; i < 9; i++) { accountNum += (i==4)? "-": rd.nextInt(10) ; }
		System.out.println("accountNum"+accountNum); 
		
		return accountNum;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:ss").format(new Date());
	}
	
	@Override
	public List<AccountBean>findAll() {
		
		return acclist ;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		
		AccountBean ab = new AccountBean();
		
		int i =0;
		for (AccountBean accountBean : acclist) {
			if(accountNum.equals(accountBean.getAccountNum())) {break;}
			i++;
		}
		
		ab = acclist.get(i);
		
		return ab;
	}

	@Override
	public int countAccounts() {
		return acclist.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean result=false;
		
		for (AccountBean accountBean : acclist) {
			if (accountNum.equals(accountBean.getAccountNum())) {
				result = true;
				break;
			}
		}
		
		return result;
	}



	@Override
	public void depositMoney(AccountBean param) {
		
		int i = 0;
		for (AccountBean accountBean : acclist) {
			if (param.getAccountNum().equals(accountBean.getAccountNum())) {
				break;
			}
			i++;
		}
		
		acclist.get(i).setMoney( String.valueOf(Integer.parseInt(param.getMoney()) +  Integer.parseInt(acclist.get(i).getMoney())));
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		int i = 0;
		for (AccountBean accountBean : acclist) {
			if (param.getAccountNum().equals(accountBean.getAccountNum())) {
				break;
			}
			i++;
		}//
		acclist.get(i).setMoney( String.valueOf(Integer.parseInt(param.getMoney()) -  Integer.parseInt(acclist.get(i).getMoney())));
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		
	acclist.remove(findByAccountNum(accountNum));
		
	}

}
