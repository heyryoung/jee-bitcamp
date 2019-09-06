package com.bank.web.pool;

import java.io.File;

public class Constants {
	   public static final String  FILE_PATH = String.format(
			   "C:%sUsers%sHR%seclipse-workspace%sjee-bitcamp%sWebContent%sRESOURCES%stxt%s",
	          File.separator,
	          File.separator,
	          File.separator,
	          File.separator,
	          File.separator,
	          File.separator,
	          File.separator,
	          File.separator);
	   
	/* public static final String VIEW_PATH = "/%s.jsp"; */
	   public static final String VIEW_PATH =  "WEB-INF/views/%s/%s.jsp";
	}
