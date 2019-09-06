package com.bank.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(Receiver.cmd.getView()+"Receiver.cmd.getView()"); 
        request.getRequestDispatcher(Receiver.cmd.getView())
        .forward(request,  response);
	} 
	
}
