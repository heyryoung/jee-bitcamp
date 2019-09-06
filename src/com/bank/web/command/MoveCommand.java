package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomain(domain);
	      setAction((request.getParameter("action")==null)
	              ? "move":
	                 request.getParameter("action"));
		excute();
		
	}
	
	public void excute() {
		super.excute();
		request.setAttribute("page", request.getParameter("page"));
	}

}
