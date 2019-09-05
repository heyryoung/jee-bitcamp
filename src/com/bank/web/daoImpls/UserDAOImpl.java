package com.bank.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bank.web.daos.UserDAO;
import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.UserBean;
import com.bank.web.pool.Constants;

public class UserDAOImpl implements UserDAO{
	
	@Override
	   public void  insertCustomer(CustomerBean param) {
	      try {
	          File file = new  File(Constants.FILE_PATH+"customers190905.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.write(String.format("%s,%s,%s,%s,%s", param.getId(),param.getPass(),param.getSsn(),param.getName(),param.getCredit()));
				writer.newLine();
				writer.flush();
	      }catch(Exception e) {
	          e.printStackTrace();
	      }
	      
	   }

	    @Override
	    public void insertEmployee(AdminBean param) {
	        
	    }
	
	    @Override
	    public boolean existCustomer(CustomerBean param) {
	    	boolean result = false;
	    	
			return result;
	    }
	    
	    public CustomerBean login(UserBean param)  {
	    	
	    	CustomerBean params = new CustomerBean();
	    		String str = "";
	    		File file = new File(Constants.FILE_PATH+"customers190905.txt");
	    		
	    		String id = param.getId();
	    		String pass = param.getPass();
	    		try {
	    			if (file.exists()) {
		    			
		    			FileReader in = new FileReader(file);
		    			BufferedReader br = new BufferedReader(in);
		    			String line="";
		    			String[] temp = new String[5];
		    			
		    				int i =0;
			    			while ((line = br.readLine()) !=null) {
			    				temp = line.split(",");
			    				
			    				if (param.getId().equals(temp[0])&&param.getPass().equals(temp[1])) {
				    				params.setId(temp[0]);
				    				params.setPass(temp[1]);
				    				params.setSsn(temp[2]);
				    				params.setName(temp[3]);
				    				params.setCredit(temp[4]);
								}
			    
			    			}
		    			

		    			br.close();
		    		}
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		
	    		return params;
	    	}
	    	

}