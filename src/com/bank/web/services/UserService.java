package com.bank.web.services;

import java.io.IOException;
import java.util.List;

import com.bank.web.domains.*;

public interface UserService {

	public void join(CustomerBean param);
	public void register(UserBean param);
	public List<CustomerBean> findAllCustomers();
	public List<AdminBean> findAllEmployees();
	public List<UserBean>  findByName(String name); 
	public UserBean findById(String id); 
	public int countCustomers(); 
	public int countEmployees(); 
	public boolean existId(String id);
	public void updatePass(UserBean param);
	public boolean deleteMember(UserBean param);
	
	
	public CustomerBean login(UserBean param) throws IOException;
	
	
}
