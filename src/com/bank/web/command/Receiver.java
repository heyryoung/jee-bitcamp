package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {

	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		try {
			cmd = new MoveCommand(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
