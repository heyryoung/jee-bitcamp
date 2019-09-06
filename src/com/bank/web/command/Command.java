package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bank.web.pool.Constants;

import lombok.Data;

@Data
public class Command implements Order{
	
	protected HttpServletRequest request;
	protected String action, domain, page, view;

	@Override
	public void excute(){
		System.out.println("1-5");
	      setDomain();
	      setPage();
	      this.view =  String.format(Constants.VIEW_PATH,  domain, page);  
	      System.out.println(this.view + "this.view1");
	}
	
	public void setDomain() {
		System.out.println("1-6");
		String path = request.getServletPath();
		domain = path.replace(".do", "");
		domain = domain.substring(1);
		System.out.println(domain + "//domain");
	}
	
	public void setPage() {
		System.out.println("1-7");
		page= request.getParameter("page");
		System.out.println(page + "// page");
	}
	
	

}
