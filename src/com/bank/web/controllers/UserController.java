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

		 String action =  request.getParameter("action");
	      String dest =  request.getParameter("dest");
	      switch(action) {
	      case "move":
	  		RequestDispatcher dispatcher = request.getRequestDispatcher(String.format("/%s.jsp", dest));
			dispatcher.forward(request, response);
	    	  
	          break;

	      case "join":
				String id = request.getParameter("id");
		        String pass = request.getParameter("pass");
		        String ssn = request.getParameter("ssn");
		        String name = request.getParameter("name");
		        String credit = request.getParameter("credit");
	          CustomerBean c = new  CustomerBean();
		        c.setId(id);
		        c.setCredit(credit);
		        c.setName(name);
		        c.setPass(pass);
		        c.setSsn(ssn);
	          System.out.println("회원정보:  "+c.toString());
		        UserService service = new UserServiceImpl();
		        service.join(c);
	  	  		dispatcher = request.getRequestDispatcher(String.format("/%s.jsp", dest));
				dispatcher.forward(request, response);
	          break;
	      case "login":
				 id = request.getParameter("id");
				 pass = request.getParameter("pass");
	            c = new  CustomerBean();
		        c.setId(id);
		        c.setPass(pass);
		        service = new UserServiceImpl();
		        CustomerBean cd = new  CustomerBean();
		        cd = service.login(c);
		        
		        String flag = cd.getId(); 
	    	  if (!(flag==null)) {
	    		  request.setAttribute("customer", cd );
	  	  		dispatcher = request.getRequestDispatcher(String.format("/%s.jsp", dest));
			}else {
	  	  		dispatcher = request.getRequestDispatcher(String.format("/%s.jsp", action));
			}
				dispatcher.forward(request, response);
	    	  break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
