package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceImpls.AccountServiceImpl;
import com.bank.web.services.AccountService;

/**
 * Servlet implementation class AdminSontroller
 */
@WebServlet("/account.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("맥락이 맞아서 여기에 도착함 6...");
		AccountBean m = new AccountBean();
		AccountService  as = new AccountServiceImpl();
		as.createAccount(request.getParameter("money"));
		System.out.println(as.findAll());
		response.setCharacterEncoding("EUC-KR");
		response.getWriter().append(as.findAll().toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
