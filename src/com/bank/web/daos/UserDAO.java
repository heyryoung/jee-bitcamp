package com.bank.web.daos;

import java.io.IOException;
import java.util.ArrayList;

import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.UserBean;

public interface UserDAO {

	void insertCustomer(CustomerBean param);

	void insertEmployee(AdminBean param);

	boolean existCustomer(CustomerBean param);

	CustomerBean[] login(UserBean param)   ;

	CustomerBean originLogin(UserBean param);
	
	
	
	
	

}