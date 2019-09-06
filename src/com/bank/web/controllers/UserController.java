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

		
			CustomerBean c;
			UserService service;
			CustomerBean cd;
			
			String action =  request.getParameter("action");
			String dest =  request.getParameter("dest");
			
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String ssn = request.getParameter("ssn");
			String name = request.getParameter("name");
			String credit = request.getParameter("credit");

			
			switch(action) {
			case "move":
				
				request.getRequestDispatcher(String.format
						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				
				break;
	
			case "join":

				c = new  CustomerBean();
				c.setId(id);
				c.setCredit(credit);
				c.setName(name);
				c.setPass(pass);
				c.setSsn(ssn);
				
				System.out.println("회원정보:  "+c.toString());
				service = new UserServiceImpl();
				service.join(c);
				
				request.getRequestDispatcher(String.format
						(Constants.VIEW_PATH,"customer",request.getParameter("dest"))).forward(request, response);
				
				break;
				
			case "login":

				c = new  CustomerBean();
				c.setId(id);
				c.setPass(pass);
				
				service = new UserServiceImpl();
				cd = new  CustomerBean();
				cd = service.login(c);
	
				if (!(cd.getId()==null)) {
					request.setAttribute("customer", cd );
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
