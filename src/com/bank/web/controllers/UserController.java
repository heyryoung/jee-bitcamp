package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImpls.UserServiceImpl;
import com.bank.web.services.UserService;

@WebServlet("/member.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			UserService service;
			CustomerBean customInfo;
			CustomerBean customList;
			
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String ssn = request.getParameter("ssn");
			String name = request.getParameter("name");
			String credit = request.getParameter("credit");
			
			switch(request.getParameter("action")) {
			case "move":
				
				request.getRequestDispatcher(String.format
						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				
				break;
	
			case "join":

				customInfo = new  CustomerBean();
				customInfo.setId(id);
				customInfo.setCredit(credit);
				customInfo.setName(name);
				customInfo.setPass(pass);
				customInfo.setSsn(ssn);
				
				System.out.println("회원정보:  "+customInfo.toString());
				service = new UserServiceImpl();
				service.join(customInfo);
				
				request.getRequestDispatcher(String.format
						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				
				break;
				
			case "login":

				customInfo = new  CustomerBean();
				customInfo.setId(id);
				customInfo.setPass(pass);
				
				service = new UserServiceImpl();
				customList = new  CustomerBean();
				customList = service.login(customInfo);
	
				if (!(customList.getId()==null)) {
					request.setAttribute("customer", customList );
					request.getRequestDispatcher(String.format
							(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
					
					
				}else {
					request.getRequestDispatcher(String.format
							(Constants.VIEW_PATH,"customer",request.getParameter("action"))).forward(request, response);
				}
				break;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
