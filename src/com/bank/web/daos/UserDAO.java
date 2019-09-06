package com.bank.web.daos;

import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.UserBean;

public interface UserDAO {

	public void insertCustomer(CustomerBean param);

	public void insertEmployee(AdminBean param);

	public boolean existCustomer(CustomerBean param);

	public CustomerBean[] login(UserBean param)  ;

	public CustomerBean originLogin(UserBean param);
	
	
	
	
	

}