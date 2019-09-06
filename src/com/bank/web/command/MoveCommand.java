package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	public MoveCommand(HttpServletRequest request) throws Exception {
		System.out.println("1-3");
		setRequest(request);
		setDomain(domain);
	      setAction((request.getParameter("action")==null)
	              ? "move":
	                 request.getParameter("action"));
	      System.out.println(getAction()+"getAction");
		excute();
		
	}
	
	public void excute() {
		System.out.println("1-4" + "/2/" );	      System.out.println("2-2");
		super.excute();
		System.out.println("1-8");    
		request.setAttribute("page", request.getParameter("page"));
	}

}
