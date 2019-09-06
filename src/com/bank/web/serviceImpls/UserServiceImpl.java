package com.bank.web.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoImpls.UserDAOImpl;
import com.bank.web.daos.UserDAO;
import com.bank.web.domains.*;
import com.bank.web.services.UserService;

public class UserServiceImpl implements UserService{

	private List<CustomerBean> cstLit;
	private List<AdminBean> adminList;
	private UserDAO dao;
	
	public UserServiceImpl() {
		cstLit = new ArrayList<>();
		adminList = new ArrayList<>();
		dao = new UserDAOImpl();
	}
	
	@Override
	public void join(CustomerBean param) {

			dao.insertCustomer(param);
	}

	// Dao에서 모든 고객 리스트를 불러와 서비스에서 로그인 처리
	@Override
	public CustomerBean login(UserBean param){
		CustomerBean[] cb = new CustomerBean[30];
		CustomerBean resultCb = new CustomerBean();
		cb = dao.login(param);
		
		for (int i = 0; i < cb.length; i++) {
			
			if (param.getId().equals(cb[i].getId()) && param.getPass().equals(cb[i].getPass())) {
				resultCb.setId(cb[i].getId());
				resultCb.setName(cb[i].getName());
				resultCb.setPass(cb[i].getPass());
				resultCb.setSsn(cb[i].getSsn());
				resultCb.setCredit(cb[i].getCredit());
				break;
				
			}
		}
		
		return resultCb;
	}
	
	
	//Dao에서 로그인처리 된 고객 한명의 데이터를 받아 컨트롤러로 리턴
	@Override
	public CustomerBean originLogin(UserBean param){
		CustomerBean resultCb = new CustomerBean();
		resultCb = dao.originLogin(param);
		
		return resultCb;
	}

	
	
	
	
	
	@Override
	public void register(UserBean param) {
		adminList.add((AdminBean)param);
		
	}

	@Override
	public List<CustomerBean> findAllCustomers() {

		
		return cstLit;
	}

	@Override
	public List<AdminBean> findAllEmployees() {
		
		return adminList;
	}

	@Override
	public List<UserBean> findByName(String name) {
		List<UserBean> ub = new ArrayList<>();
		
		for (CustomerBean csb : cstLit) {
			if (name.equals(csb.getName())) {
				ub.add(csb);
			}
		}
		
		for (AdminBean adminBean : adminList) {
			if (name.equals(adminBean.getName())) {
				ub.add(adminBean);
			}
		}
		
		return ub;
	}

	@Override
	public UserBean findById(String id) {
		UserBean ub = new UserBean();
		for (CustomerBean csb : cstLit) {
			if (id.equals(csb.getId())) {
				ub = csb;
				break;
			}
		}
		for (AdminBean adminBean : adminList) {
			if (id.equals(adminBean.getId())) {
				ub = adminBean;
				break;
			}
		}
		
		return ub;
	}

	/*
	 * @Override public boolean login(UserBean param) { boolean result = false;
	 * String id = param.getId(); String pw = param.getPass();
	 * 
	 * for (CustomerBean csb : cstLit) { if
	 * (id.equals(csb.getId())&&pw.equals(csb.getPass())) { result = true; break; }
	 * } for (AdminBean ab : adminList) { if
	 * (id.equals(ab.getId())&&pw.equals(ab.getPass())) { result = true; break; } }
	 * 
	 * 
	 * return result; }
	 */

	@Override
	public int countCustomers() {
		return cstLit.size();
	}

	@Override
	public int countEmployees() {
		return adminList.size();
	}

	@Override
	public boolean existId(String id) {
		
		return (findById(id).equals(null)) ? false : true;
	}

	@Override
	public void updatePass(UserBean param) {

		String id = param.getId();
		String  opw = param.getPass().split(",")[0];
		String  npw = param.getPass().split(",")[1];
		for (CustomerBean csb : cstLit) {
			if (id.equals(csb.getId())&&opw.equals(csb.getPass())) {
				csb.setPass(npw);
				break;
			}
		}
		for (AdminBean ab : adminList) {
			if (id.equals(ab.getId())&&opw.equals(ab.getPass())) {
				ab.setPass(npw);
				break;
			}
		}
		
	}

	@Override
	public boolean deleteMember(UserBean param) {

		UserBean u = findById(param.getId());
		
		return cstLit.contains(u) ?  cstLit.remove(u) : adminList.remove(u);
		
	}


}
