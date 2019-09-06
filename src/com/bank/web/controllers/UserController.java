package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Sender;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceImpls.UserServiceImpl;
import com.bank.web.services.UserService;

import lombok.Data;

@WebServlet("/customer.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserService service;
		CustomerBean customInfo;
		CustomerBean customList;
		Order order;
		MoveCommand	cmd = null;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String ssn = request.getParameter("ssn");
		String name = request.getParameter("name");
		String credit = request.getParameter("credit");
		
		System.out.println("1-1");
	      Receiver.init(request);
	      System.out.println("2-1");
	      Receiver.cmd.excute();
	      System.out.println("Receiver.cmd.excute()  END");
	      if(Receiver.cmd.getAction()==null)  {
	          Receiver.cmd.setPage();
	      }

		switch(Receiver.cmd.getAction()) {
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
			
            Receiver.cmd.setPage("login");
			break;

		case "login":

			customInfo = new  CustomerBean();
			customInfo.setId(id);
			customInfo.setPass(pass);

			service = new UserServiceImpl();
			customList = new  CustomerBean();
			customList = service.login(customInfo);

			if (customList.getId()==null) {
                Receiver.cmd.setPage("login");
      	      System.out.println(Receiver.cmd.getPage()+"UserController/login/Receiver.cmd.getPage()");
			}else {
			      System.out.println(Receiver.cmd.getAction()+"asdfasdf");
				request.setAttribute("customer", customList );
				Receiver.cmd.setPage("mypage");
			}               
			break;
        case "existId":
            break;
		}

	      Sender.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
