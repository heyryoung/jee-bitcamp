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
	    
	    
	    //모든 고객의 데이터를 리턴
	    public CustomerBean[] login(UserBean param)  {
	    	
	    		CustomerBean[] params = new CustomerBean[30];
	    		File file = new File(Constants.FILE_PATH+"customers190905.txt");
	    		
	    		try {
	    			if (file.exists()) {
		    			
		    			BufferedReader br = new BufferedReader(new FileReader(file));
		    			String line="";
		    			String[] temp = new String[5];
		    			int cnt =0;
		    			
			    			while ((line = br.readLine()) !=null) {
			    				temp = line.split(",");
			    	    		CustomerBean cbTemp = new CustomerBean();
			    	    		cbTemp.setId(temp[0]);
			    	    		cbTemp.setPass(temp[1]);
			    	    		cbTemp.setSsn(temp[2]);
			    	    		cbTemp.setName(temp[3]);
			    	    		cbTemp.setCredit(temp[4]);
				    				
			    	    		params[cnt] = cbTemp;
				    				cnt++;
			    			}

		    			br.close();
		    		}
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		
	    		return params;
	    	}
	    	
	    
	    // 아이디와 비밀번호가 일치하는 고객의 데이터만 리턴
	    public CustomerBean originLogin(UserBean param)  {
	    	
    		File file = new File(Constants.FILE_PATH+"customers190905.txt");
    		CustomerBean resultCb = new CustomerBean();
    		
    		try {
    			if (file.exists()) {
	    			
	    			BufferedReader br = new BufferedReader(new FileReader(file));
	    			String line="";
	    			String[] temp = new String[5];
	    			int cnt =0;
	    			
		    			while ((line = br.readLine()) !=null) {
		    				temp = line.split(",");
		    				if (param.getId().equals(temp[0]) && param.getPass().equals(temp[1])) {
		    					resultCb.setId(temp[0]);
		    					resultCb.setPass(temp[1]);
		    					resultCb.setSsn(temp[2]);
		    					resultCb.setName(temp[3]);
		    					resultCb.setCredit(temp[4]);
		    					break;
							}

		    			}

	    			br.close();
	    		}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		return resultCb;
    	}
	    
	    

}